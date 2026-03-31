package com.senai.api.controllers;

import com.senai.api.dtos.LoginDto;
import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.dtos.SenhaDto;
import com.senai.api.dtos.UsuarioDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> logar (@RequestBody LoginDto loginDto){

        if (loginDto.getLogin().isBlank() || loginDto.getSenha().isBlank()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email e senha são obrigatórios.");
        }

        boolean retorno = service.logar(loginDto);
            if (retorno) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Login realizado com sucesso.");

            }else{
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Erro ao realizar login: credenciais inválidas.");

            }
    }
    @PutMapping("/usuario/senha/{login}")
    public ResponseEntity<String> trocarSenha(@PathVariable String login, @RequestBody SenhaDto senhaDto){

        if (senhaDto.getSenhaAtual().isBlank() || senhaDto.getSenhaNova().isBlank()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Senha atual e nova senha são obrigatórias.");
        }

        if (senhaDto.getSenhaNova().length()>8){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao realizar a troca de senha: a nova senha deve ter pelo menos 8 caracteres.");

        }



        boolean retorno = service.trocarSenha(login, senhaDto);
        if (retorno){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Senha alterada com sucesso.");

        }else{
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Erro ao realizar a troca de senha: senha atual ou login incorreto.");

        }
    }
}
