package com.faculdade.treino_api.controller;

import com.faculdade.treino_api.dto.ExercicioDTO;
import com.faculdade.treino_api.model.Exercicio;
import com.faculdade.treino_api.model.Ficha;
import com.faculdade.treino_api.repository.FichaRepository;
import com.faculdade.treino_api.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;
    private final FichaRepository fichaRepository;

    public ExercicioController(ExercicioService exercicioService, FichaRepository fichaRepository) {
        this.exercicioService = exercicioService;
        this.fichaRepository = fichaRepository;
    }

    // 1. POST: Criar um novo exercício
    @PostMapping
    public ResponseEntity<Exercicio> criar(@Valid @RequestBody ExercicioDTO dto) {
        Ficha ficha = fichaRepository.findById(dto.getFichaId())
                .orElseThrow(() -> new RuntimeException("Ficha não encontrada"));

        Exercicio exercicio = new Exercicio();
        exercicio.setNomeMovimento(dto.getNomeMovimento());
        exercicio.setSeries(dto.getSeries());
        exercicio.setCargaAtual(dto.getCargaAtual());
        exercicio.setFicha(ficha);

        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioService.salvar(exercicio));
    }

    // 2. GET: Listar todos os exercícios
    @GetMapping
    public ResponseEntity<List<Exercicio>> listarTodos() {
        return ResponseEntity.ok(exercicioService.listarTodos());
    }

    // 3. GET por ID: Buscar um exercício específico
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarPorId(@PathVariable Long id) {
        return exercicioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. PUT: Atualizar a carga ou séries de um exercício
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long id, @Valid @RequestBody ExercicioDTO dto) {
        Exercicio dadosAtualizados = new Exercicio();
        dadosAtualizados.setNomeMovimento(dto.getNomeMovimento());
        dadosAtualizados.setSeries(dto.getSeries());
        dadosAtualizados.setCargaAtual(dto.getCargaAtual());

        return ResponseEntity.ok(exercicioService.atualizar(id, dadosAtualizados));
    }

    // 5. DELETE: Remover um exercício da ficha
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        exercicioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // 6. GET: Buscar exercícios com base em parte do nome (ex: "Supino")
    @GetMapping("/filtro")
    public ResponseEntity<List<Exercicio>> buscarPorFiltroNome(@RequestParam String nome) {
        List<Exercicio> filtrados = exercicioService.listarTodos().stream()
                .filter(e -> e.getNomeMovimento().toLowerCase().contains(nome.toLowerCase()))
                .toList();
        return ResponseEntity.ok(filtrados);
    }
}