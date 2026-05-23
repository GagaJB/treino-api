package com.faculdade.treino_api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_exercicio")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMovimento;
    private Integer series;
    private Double cargaAtual;

    @ManyToOne
    @JoinColumn(name = "ficha_id")
    @JsonIgnore
    private Ficha ficha;

    // Construtor vazio
    public Exercicio() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeMovimento() { return nomeMovimento; }
    public void setNomeMovimento(String nomeMovimento) { this.nomeMovimento = nomeMovimento; }

    public Integer getSeries() { return series; }
    public void setSeries(Integer series) { this.series = series; }

    public Double getCargaAtual() { return cargaAtual; }
    public void setCargaAtual(Double cargaAtual) { this.cargaAtual = cargaAtual; }

    public Ficha getFicha() { return ficha; }
    public void setFicha(Ficha ficha) { this.ficha = ficha; }


}