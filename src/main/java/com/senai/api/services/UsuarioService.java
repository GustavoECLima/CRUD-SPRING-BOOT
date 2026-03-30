package com.senai.api.services;

import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.dtos.UsuarioDto;
import com.senai.api.entities.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioEntity> listaUsuario = new ArrayList<UsuarioEntity>();

    public boolean cadastrar(UsuarioDto usuarioDto){

        //--Validar se o logi já existe
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

    public boolean atualizar(String CPF, UsuarioDto usuarioDto) {

        for (UsuarioEntity usuario: listaUsuario){
            if (usuario.getLogin().equals(usuarioDto.getLogin()) && !usuario.getCPF().equals(CPF)){
                    return false;
            }
        }

        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getCPF().equals(CPF)) {

                usuario.setCPF(usuarioDto.getCPF());
                usuario.setLogin(usuarioDto.getCPF());
                usuario.setNome(usuarioDto.getCPF());
                usuario.setSenha(usuarioDto.getCPF());

                return true;
            }
        }
        return true;
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


//    public String BuscarPorCPF(String cpf){
//
//        String UsuarioEncontrado = "Usuario não existe";
//
//        for (UsuarioEntity encontre : listaUsuario){
//            if (encontre.getCPF().equals(cpf)){
//                return UsuarioEncontrado = "CPF: " + encontre.getCPF()+"/n"+
//                                            "Nome: " + encontre.getLogin()+"/n"+
//                                            "Login: " + encontre.getNome();
//            }
//
//        }
//        return UsuarioEncontrado;
//    }

}
