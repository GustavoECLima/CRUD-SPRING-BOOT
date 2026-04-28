package com.senai.api.controllers;

import com.senai.api.dtos.CategoriaDto;
import com.senai.api.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/categoria")
    public ResponseEntity<String> cadastrar(@RequestBody CategoriaDto categoriaDto){
        boolean retorno = service.cadastrarCategoria(categoriaDto);
        if (retorno){
            return ResponseEntity.status(HttpStatus.OK).body("Categoria cadastrada");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar Categoria");
        }
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> obterCategorias(){
        List<CategoriaDto> lista = service.obterCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
