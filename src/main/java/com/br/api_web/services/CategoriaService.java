package com.br.api_web.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.api_web.DTO.Request.CategoriaReqDTO;
import com.br.api_web.DTO.Response.CategoriaResDTO;
import com.br.api_web.models.Categoria;
import com.br.api_web.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaResDTO> listarCategorias(){
        return categoriaRepository.findAll()
        .stream().map(c -> new CategoriaResDTO(c.getId(),c.getNome(), c.getDescricao())).collect(Collectors.toList());
    }

    public CategoriaResDTO buscarPorId(Long id){
        Categoria categoria = categoriaRepository.findCategoria(id).orElseThrow(() -> new RuntimeException("Não existe uma categoria com este ID"));
        return new CategoriaResDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

    public CategoriaResDTO criarCategoria(CategoriaReqDTO categoria){
        Categoria novaCategoria = new Categoria(null, categoria.getNome(), categoria.getDescricao());
        Categoria categoriaSalva = categoriaRepository.addCategoria(novaCategoria);
        return new CategoriaResDTO(categoriaSalva.getId(), categoriaSalva.getNome(), categoriaSalva.getDescricao());
    }

    public CategoriaResDTO atualizaCategoria(Long id, CategoriaReqDTO categoria){
        Categoria categoriaExiste = categoriaRepository.findCategoria(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaExiste.setNome(categoria.getNome());
        categoriaExiste.setDescricao(categoria.getDescricao());
        Categoria categoriaAtualizada = categoriaRepository.update(categoriaExiste);

        return new CategoriaResDTO(categoriaAtualizada.getId(),categoriaAtualizada.getNome() , categoriaAtualizada.getDescricao());
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
