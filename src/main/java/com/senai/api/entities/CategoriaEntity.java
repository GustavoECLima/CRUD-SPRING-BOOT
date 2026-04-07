package com.senai.api.entities;

public class CategoriaEntity {

    private Long id;
    private String nome;

    public CategoriaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaEntity() {
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
}
