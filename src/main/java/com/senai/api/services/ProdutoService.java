package com.senai.api.services;

import com.senai.api.dtos.ProdutoDto;
import com.senai.api.entities.CategoriaEntity;
import com.senai.api.entities.ProdutoEntity;
import com.senai.api.repositories.CategoriaRepository;
import com.senai.api.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoService {

    public ProdutoRepository produtoRepository;
    public CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public boolean cadastrarProduto(ProdutoDto produtoDto){
        //nome
        //valor
        //idCategoria

        Optional<CategoriaEntity> categoriaOP = categoriaRepository.findById(produtoDto.getCategoriaId());

        ProdutoEntity produto = new ProdutoEntity(produtoDto);
        produto.setCategoria(categoriaOP.get());
        produtoRepository.save(produto);
        return true;
    }

    public List<ProdutoDto> obterProdutos(){

        List<ProdutoDto> listaProdutoDto = new ArrayList<>();
        List<ProdutoEntity> listaProduto = produtoRepository.findAll();

        for (ProdutoEntity produto : listaProduto){
            ProdutoDto produtoDto = new ProdutoDto(produto);

            produtoDto.setCategoriaId(produto.getCategoria().getId());
            listaProdutoDto.add(produtoDto);
        }

        return listaProdutoDto;
    }

    public List<ProdutoDto> obterProdutoPorCategoria(Long categoriaId){

        List<ProdutoDto> listaProdutoDto = new ArrayList<>();
        List<ProdutoEntity> listaProduto = produtoRepository.findAll();

        for (ProdutoEntity produto : listaProduto){
            if (Objects.equals(produto.getCategoria(), categoriaId)) {
                ProdutoDto produtoDto = new ProdutoDto(produto);
                listaProdutoDto.add(produtoDto);
            }
        }
        return listaProdutoDto;
    }
}

