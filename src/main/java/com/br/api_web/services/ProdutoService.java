package com.br.api_web.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.api_web.repository.ProdutoRepository;
import com.br.api_web.DTO.Request.ProdutoReqDTO;
import com.br.api_web.DTO.Response.ProdutoResDTO;
import com.br.api_web.models.Produto;
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResDTO> listarProdutos(){
        return produtoRepository.findAll().stream()
        .map(p -> new ProdutoResDTO(p.getId(),p.getNome(), p.getPreco())).collect(Collectors.toList());
    }

    public ProdutoResDTO getProductById(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new ProdutoResDTO(produto.getId(), produto.getNome(), produto.getPreco());
    }


    public ProdutoResDTO postProduct(ProdutoReqDTO produto){
        Produto novoProduto = new Produto(null, produto.getNome(), produto.getPreco(), produto.getnSerie());
        Produto produtoSalvo = produtoRepository.save(novoProduto);
        return new ProdutoResDTO(produtoSalvo.getId(),produtoSalvo.getNome(), produto.getPreco());
    }


    public ProdutoResDTO updateProduct(Long id, ProdutoReqDTO produto){
        Produto produtoExist = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoExist.setNome(produto.getNome());
        produtoExist.setPreco(produto.getPreco());
        produtoExist.setnSerie(produto.getnSerie());
        Produto produtoUpdated = produtoRepository.update(produtoExist);

        return new ProdutoResDTO(produtoUpdated.getId(), produtoUpdated.getNome(), produtoUpdated.getPreco());
    }

    public void deleteProduct(Long id){

    }
}
