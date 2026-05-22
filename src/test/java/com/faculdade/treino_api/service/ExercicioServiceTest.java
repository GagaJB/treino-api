package com.faculdade.treino_api.service;

import com.faculdade.treino_api.model.Exercicio;
import com.faculdade.treino_api.repository.ExercicioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExercicioServiceTest {

    @Mock
    private ExercicioRepository exercicioRepository;

    @InjectMocks
    private ExercicioService exercicioService;

    @Test
    void deveSalvarExercicioComSucesso() {
        Exercicio exercicio = new Exercicio();
        exercicio.setNomeMovimento("Desenvolvimento");

        when(exercicioRepository.save(any(Exercicio.class))).thenReturn(exercicio);

        Exercicio salvo = exercicioService.salvar(exercicio);

        assertNotNull(salvo);
        assertEquals("Desenvolvimento", salvo.getNomeMovimento());
        verify(exercicioRepository, times(1)).save(exercicio);
    }

    @Test
    void deveLancarExcecaoAoAtualizarExercicioInexistente() {
        when(exercicioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            exercicioService.atualizar(99L, new Exercicio());
        });
    }
}