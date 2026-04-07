package com.senai.api.controllers;

import com.senai.api.dtos.ProdutoDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {
    private final UsuarioService service;

    public ProdutoController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/produtos")
    public ResponseEntity<String> cadastrar (@RequestBody ProdutoDto produtoDto){
        if (produtoDto.getNome().isBlank()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Nome de produto não pode ser nulo");
        }

        if (produtoDto.getPreco() < 0){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Preço do produto não pode ser menor que ZERO.");
        }

        boolean retorno = service.cadastrarProduto(produtoDto);

        if (retorno){
            return ResponseEntity
                    .ok()
                    .body("Produto adicionado com sucesso");
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categoria não encontrada.");
        }

    }

}
