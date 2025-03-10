package com.br.api_web.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.br.api_web.models.Categoria;

import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository {
    private static List<Categoria> categorias = new ArrayList<>();
    private Long nextId = 1L;



    public Categoria addCategoria(Categoria categoria){
        categoria.setId(nextId++);
        categorias.add(categoria);
        return categoria;
    }

    public List<Categoria> findAll(){
        return categorias;
    }

    public Optional<Categoria> findCategoria(Long id){
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst();   
    }

    public Categoria update(Categoria categoria){
        return categorias.stream()
                .filter(c -> c.getId().equals(categoria.getId()))
                .findFirst().map(c -> {
                    c.setNome(categoria.getNome());
                    c.setDescricao(categoria.getDescricao());
                    return c;
                }).orElseThrow(() -> new RuntimeException("Não foi encontrada a Categoria referente a alterar"));
    }

    public void deleteById(Long id){
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}
