package com.faculdade.treino_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_ficha")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String focoMuscular;

    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL)
    private List<Exercicio> exercicios;

    // Construtor vazio exigido pelo JPA
    public Ficha() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFocoMuscular() { return focoMuscular; }
    public void setFocoMuscular(String focoMuscular) { this.focoMuscular = focoMuscular; }

    public List<Exercicio> getExercicios() { return exercicios; }
    public void setExercicios(List<Exercicio> exercicios) { this.exercicios = exercicios; }
}