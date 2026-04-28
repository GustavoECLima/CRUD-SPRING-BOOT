package com.senai.api.entities;

import com.senai.api.dtos.CategoriaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    public CategoriaEntity() {
    }

    public CategoriaEntity(CategoriaDto categoriaDto){
        this.setId(categoriaDto.getId());
        this.setNome(categoriaDto.getNome());
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
