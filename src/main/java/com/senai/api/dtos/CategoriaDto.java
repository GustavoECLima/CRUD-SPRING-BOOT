package com.senai.api.dtos;

public class CategoriaDto {

    private Long id;
    private String nome;

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDto() {
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
