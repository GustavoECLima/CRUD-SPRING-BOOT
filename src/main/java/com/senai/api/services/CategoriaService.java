package com.senai.api.services;

import com.senai.api.dtos.CategoriaDto;
import com.senai.api.entities.CategoriaEntity;
import com.senai.api.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrarCategoria(CategoriaDto categoriaDto){

        CategoriaEntity categoria = new CategoriaEntity(categoriaDto);
        //--converção dos campos de dto para entity
        repository.save(categoria);
        return true;
    }

    public List<CategoriaDto> obterCategorias(){

        List<CategoriaDto> listaCategoriaDto = new ArrayList<>();

        List<CategoriaEntity> listaCategoria = repository.findAll();

        for (CategoriaEntity categoria : listaCategoria){
            CategoriaDto categoriaDto = new CategoriaDto(categoria);
            listaCategoriaDto.add(categoriaDto);
        }

        return listaCategoriaDto;
    }
}
