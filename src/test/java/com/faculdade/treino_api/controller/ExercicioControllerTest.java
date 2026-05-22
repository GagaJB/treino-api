package com.faculdade.treino_api.controller;

import com.faculdade.treino_api.dto.ExercicioDTO;
import com.faculdade.treino_api.model.Exercicio;
import com.faculdade.treino_api.model.Ficha;
import com.faculdade.treino_api.repository.FichaRepository;
import com.faculdade.treino_api.service.ExercicioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExercicioControllerTest {

    @Mock
    private ExercicioService exercicioService;

    @Mock
    private FichaRepository fichaRepository;

    @InjectMocks
    private ExercicioController exercicioController;

    @Test
    void deveRetornarCreatedAoCriarExercicioValido() {
        ExercicioDTO dto = new ExercicioDTO();
        dto.setNomeMovimento("Desenvolvimento");
        dto.setSeries(4);
        dto.setCargaAtual(20.0);
        dto.setFichaId(1L);

        Ficha ficha = new Ficha();
        ficha.setId(1L);

        Exercicio exercicioSalvo = new Exercicio();
        exercicioSalvo.setNomeMovimento("Desenvolvimento");

        when(fichaRepository.findById(1L)).thenReturn(Optional.of(ficha));
        when(exercicioService.salvar(any(Exercicio.class))).thenReturn(exercicioSalvo);

        ResponseEntity<Exercicio> response = exercicioController.criar(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Desenvolvimento", response.getBody().getNomeMovimento());
    }
}