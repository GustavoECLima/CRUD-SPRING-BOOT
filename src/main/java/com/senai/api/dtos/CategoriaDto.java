package com.senai.api.dtos;

import com.senai.api.entities.CategoriaEntity;

public class CategoriaDto {

    private Long id;
    private String nome;


    public CategoriaDto() {
    }

    public CategoriaDto(CategoriaEntity categoria) {
        this.setId(categoria.getId());
        this.setNome(categoria.getNome());
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
