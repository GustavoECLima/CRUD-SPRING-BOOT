package com.senai.api.entities;

import com.senai.api.dtos.CategoriaDto;
import com.senai.api.dtos.ProdutoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    private CategoriaEntity categoria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    public ProdutoEntity() {
    }

    public ProdutoEntity(ProdutoDto produtoDto){
        this.setId(produtoDto.getId());
        this.setNome(produtoDto.getNome());
        this.setPreco(produtoDto.getPreco());


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

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
}
