package com.faculdade.treino_api.service;

import com.faculdade.treino_api.model.Exercicio;
import com.faculdade.treino_api.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    // Injeção de dependência via construtor
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    public Optional<Exercicio> buscarPorId(Long id) {
        return exercicioRepository.findById(id);
    }

    public Exercicio atualizar(Long id, Exercicio dadosAtualizados) {
        return exercicioRepository.findById(id).map(exercicio -> {
            exercicio.setNomeMovimento(dadosAtualizados.getNomeMovimento());
            exercicio.setSeries(dadosAtualizados.getSeries());
            exercicio.setCargaAtual(dadosAtualizados.getCargaAtual());
            return exercicioRepository.save(exercicio);
        }).orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    public void deletar(Long id) {
        exercicioRepository.deleteById(id);
    }
}