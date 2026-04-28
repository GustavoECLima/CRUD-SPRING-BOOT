package com.senai.api.dtos;

import com.senai.api.entities.ProdutoEntity;

public class ProdutoDto {

    private Long id;
    private String nome;
    private Double preco;
    private Long categoriaId;

    public ProdutoDto() {
    }

    public ProdutoDto(ProdutoEntity produto){
        this.setId(produto.getId());
        this.setNome(produto.getNome());
        this.setPreco(produto.getPreco());
        //this.setCategoriaId(produto.getCategoriaId());
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
