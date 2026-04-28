package com.senai.api.controllers;

import com.senai.api.dtos.ProdutoDto;
import com.senai.api.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService serviceProduto;

    public ProdutoController(ProdutoService service) {
        this.serviceProduto = service;
    }

    @PostMapping("/produto")
    public ResponseEntity<String> cadastrar(@RequestBody ProdutoDto produtoDto) {
        boolean retorno = serviceProduto.cadastrarProduto(produtoDto);
        if (retorno) {
            return ResponseEntity.status(HttpStatus.OK).body("Produto cadastrado");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar Produto");
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> obterProdutos(){
        List<ProdutoDto> lista = serviceProduto.obterProdutos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
