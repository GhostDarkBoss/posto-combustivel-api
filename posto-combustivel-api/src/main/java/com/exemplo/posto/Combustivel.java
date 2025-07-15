package com.exemplo.posto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Combustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double precoPorLitro;

    public Combustivel() {}

    public Combustivel(Long id, String nome, Double precoPorLitro) {
        this.id = id;
        this.nome = nome;
        this.precoPorLitro = precoPorLitro;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPrecoPorLitro() { return precoPorLitro; }
    public void setPrecoPorLitro(Double precoPorLitro) { this.precoPorLitro = precoPorLitro; }
}
