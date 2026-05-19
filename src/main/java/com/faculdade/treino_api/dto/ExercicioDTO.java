package com.faculdade.treino_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ExercicioDTO {

    @NotBlank(message = "O nome do movimento não pode estar vazio")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nomeMovimento;

    @NotNull(message = "O número de séries é obrigatório")
    @Positive(message = "O número de séries deve ser maior que zero")
    private Integer series;

    @NotNull(message = "A carga atual é obrigatória")
    @Positive(message = "A carga deve ser maior que zero")
    private Double cargaAtual;

    @NotNull(message = "O ID da ficha é obrigatório")
    private Long fichaId;

    // Getters e Setters
    public String getNomeMovimento() { return nomeMovimento; }
    public void setNomeMovimento(String nomeMovimento) { this.nomeMovimento = nomeMovimento; }

    public Integer getSeries() { return series; }
    public void setSeries(Integer series) { this.series = series; }

    public Double getCargaAtual() { return cargaAtual; }
    public void setCargaAtual(Double cargaAtual) { this.cargaAtual = cargaAtual; }

    public Long getFichaId() { return fichaId; }
    public void setFichaId(Long fichaId) { this.fichaId = fichaId; }
}