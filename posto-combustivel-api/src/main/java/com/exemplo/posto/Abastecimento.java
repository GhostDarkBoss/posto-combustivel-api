package com.exemplo.posto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BombaCombustivel bomba;

    private LocalDateTime data;

    private Double valorTotal;

    private Double litragem;

    public Abastecimento() {}

    public Abastecimento(Long id, BombaCombustivel bomba, LocalDateTime data, Double valorTotal, Double litragem) {
        this.id = id;
        this.bomba = bomba;
        this.data = data;
        this.valorTotal = valorTotal;
        this.litragem = litragem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BombaCombustivel getBomba() {
        return bomba;
    }

    public void setBomba(BombaCombustivel bomba) {
        this.bomba = bomba;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getLitragem() {
        return litragem;
    }

    public void setLitragem(Double litragem) {
        this.litragem = litragem;
    }
}
