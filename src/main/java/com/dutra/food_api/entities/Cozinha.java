package com.dutra.food_api.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_cozinha")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    public Cozinha() {}
    public Cozinha(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cozinha cozinha = (Cozinha) o;
        return Objects.equals(id, cozinha.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
