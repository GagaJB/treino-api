package com.faculdade.treino_api.controller;

import com.faculdade.treino_api.model.Ficha;
import com.faculdade.treino_api.repository.FichaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichas")
public class FichaController {

    private final FichaRepository fichaRepository;

    public FichaController(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    // Rota para criar uma nova ficha
    @PostMapping
    public ResponseEntity<Ficha> criar(@RequestBody Ficha ficha) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaRepository.save(ficha));
    }

    // Rota para listar as fichas
    @GetMapping
    public ResponseEntity<List<Ficha>> listarTodas() {
        return ResponseEntity.ok(fichaRepository.findAll());
    }
}