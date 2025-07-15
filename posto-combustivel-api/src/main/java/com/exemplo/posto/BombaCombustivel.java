package com.exemplo.posto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BombaCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Combustivel combustivel;
// Para enviar via JSON na API, você precisará enviar o objeto completo ou pelo menos o id dentro do objeto combustivel.
    public BombaCombustivel() {}

    public BombaCombustivel(Long id, String nome, Combustivel combustivel) {
        this.id = id;
        this.nome = nome;
        this.combustivel = combustivel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Combustivel getCombustivel() { return combustivel; }
    public void setCombustivel(Combustivel combustivel) { this.combustivel = combustivel; }
}
