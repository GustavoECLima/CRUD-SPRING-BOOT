package com.senai.api.controllers;

import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.dtos.UsuarioDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    //--Insjeção de dependencia
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuario")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioDto usuarioDto){

        boolean retorno = service.cadastrar(usuarioDto);
        if (retorno) {
            return ResponseEntity.ok().body("Cadastrado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Já existe este login cadastrado!");
        }
    }

    @PutMapping("/usuario/{cpf}")
    public ResponseEntity<String> atualizar(@RequestBody UsuarioDto usuarioDto, @PathVariable String cpf){

        boolean retorno = service.atualizar(cpf, usuarioDto);

        if (retorno) {
            return ResponseEntity.ok().body("Atualizado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Já existe este login cadastrado!");
        }

    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<RespostaUsuarioDto>> obterUsuarios(){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/usuario/{cpf}")
    public ResponseEntity<RespostaUsuarioDto> obterUsuarioPorCpf(@PathVariable String cpf){
        RespostaUsuarioDto resposta = service.buscar(cpf);
        if (resposta.getCPF().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(resposta);
        }
    }

    @DeleteMapping("/usuario/{cpf}")
    public ResponseEntity<String> removerUsuario(@PathVariable String cpf){
        boolean retorno = service.deletar(cpf);
        if (retorno){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Exclusão com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }


}
