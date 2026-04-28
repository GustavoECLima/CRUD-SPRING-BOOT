package com.senai.api.services;

import com.senai.api.dtos.*;
import com.senai.api.entities.CategoriaEntity;
import com.senai.api.entities.ProdutoEntity;
import com.senai.api.entities.UsuarioEntity;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioEntity> listaUsuario = new ArrayList<UsuarioEntity>();

    public boolean cadastrar(UsuarioDto usuarioDto){

        //--Validar se o login já existe
        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getLogin().equals(usuarioDto.getLogin())){
                //--Se já existe, retorna para o controller como false
                return false;
            }
        }

        UsuarioEntity usuario = new UsuarioEntity();

        //--Converter dados do DTO para o ENTITY
        usuario.setCPF(usuarioDto.getCPF());
        usuario.setNome(usuarioDto.getNome());
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setSenha(usuarioDto.getSenha());

        listaUsuario.add(usuario);

        //--Se chegou até aqui significa que o usuário foi inserido com sucesso!
        return true;
    }

    public boolean atualizar(String CPF, UsuarioDto usuarioDto) {

        for (UsuarioEntity usuario: listaUsuario){
            if (usuario.getLogin().equals(usuarioDto.getLogin()) && !usuario.getCPF().equals(CPF)){
                return false;
            }
        }

        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getCPF().equals(CPF)) {

                usuario.setCPF(usuarioDto.getCPF());
                usuario.setLogin(usuarioDto.getLogin());
                usuario.setNome(usuarioDto.getNome());
                return true;
            }
        }
        return true;
    }

    public List listar(){

        List<RespostaUsuarioDto> listaGET = new ArrayList<RespostaUsuarioDto>();

        for (UsuarioEntity lista : listaUsuario){
            RespostaUsuarioDto usuarioGET = new RespostaUsuarioDto();
            usuarioGET.setNome(lista.getNome());
            usuarioGET.setCPF(lista.getCPF());
            usuarioGET.setLogin(lista.getLogin());

            listaGET.add(usuarioGET);
        }

        return listaGET;
    }

    public RespostaUsuarioDto buscar(String cpf){

        RespostaUsuarioDto usuarioDto = new RespostaUsuarioDto();

        for (UsuarioEntity usuario: listaUsuario){
            if (usuario.getCPF().equals(cpf)){
                usuarioDto.setCPF(usuario.getCPF());
                usuarioDto.setLogin(usuario.getLogin());
                usuarioDto.setNome(usuario.getNome());
                break;
            }
        }
        return usuarioDto;
    }

    public boolean deletar(String CPF) {

        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getCPF().equals(CPF)) {
                listaUsuario.remove(usuario);
                return true;
            }
        }
        return true;
    }

    public boolean logar(LoginDto loginDto) {

        for (UsuarioEntity usuario: listaUsuario){
            if (loginDto.getLogin().equals(usuario.getLogin()) && loginDto.getSenha().equals(usuario.getSenha())){
                return true;
            }
        }
        return false;
    }

    public boolean trocarSenha(String login, SenhaDto senhaDto){
        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getLogin().equals(login)) {
                if (senhaDto.getSenhaAtual().equals(usuario.getSenha())) {
                    usuario.setSenha(senhaDto.getSenhaNova());
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}
