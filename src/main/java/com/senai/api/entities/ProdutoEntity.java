package com.senai.api.entities;

public class ProdutoEntity {

    private Long id;
    private String nome;
    private double preco;
    private Long idCategoria;

    public ProdutoEntity(Long id, String nome, double preco, Long idCategoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.idCategoria = idCategoria;
    }

    public ProdutoEntity() {
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

}

