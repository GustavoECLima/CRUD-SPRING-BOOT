package com.senai.api.controllers;

import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.dtos.UsuarioDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuario")
    public ResponseEntity<String> cadastrar (@RequestBody UsuarioDto usuarioDto) {
        boolean retorno = service.cadastrar(usuarioDto);
        if (retorno) {
            return ResponseEntity.ok().body("Cadastrado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Já existe este login cadastrado!");
        }
    }

    @PutMapping("/usuario/{cpf}")
    public  ResponseEntity<String> atualizar (@RequestBody UsuarioDto usuarioDto, @PathVariable String cpf) {

        boolean retorno = service.atualizar(cpf, usuarioDto);

        if (retorno) {
            service.atualizar(cpf, usuarioDto);
            return ResponseEntity.ok().body("Usuario atualizado");

        } else {
            return ResponseEntity.badRequest().body("Já existe este login cadastrado!");
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List> listar (){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/usuario/{cpf}")
    public  ResponseEntity<RespostaUsuarioDto> buscar (@PathVariable String cpf) {

        return ResponseEntity.ok().body(service.buscar(cpf));
    }

    @DeleteMapping("/usuario/{cpf}")
    public  ResponseEntity<String> deletar (@PathVariable String cpf) {

        boolean retorno = service.deletar(cpf);
        if (retorno){
            return ResponseEntity.ok().body("Usuário deletado com sucesso!");
        }else{
            return ResponseEntity.ok().body("Usuário não encontrado!");
        }
    }
}
