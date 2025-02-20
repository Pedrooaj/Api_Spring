package com.br.api_web.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.api_web.repository.ProdutoRepository;
import com.br.api_web.DTO.Response.ProdutoResDTO;
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResDTO> listarProdutos(){
        return produtoRepository.findAll().stream()
        .map(p -> new ProdutoResDTO(p.getId(),p.getNome(), p.getPreco(),p.getnSerie())).collect(Collectors.toList());
    }
}
