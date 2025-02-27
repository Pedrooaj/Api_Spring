package com.br.api_web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api_web.DTO.Request.ProdutoReqDTO;
import com.br.api_web.DTO.Response.ProdutoResDTO;
import com.br.api_web.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResDTO>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProdutoResDTO> criarProduto(@RequestBody ProdutoReqDTO produto){
        return ResponseEntity.ok(produtoService.postProduct(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoReqDTO produto){
        return ResponseEntity.ok(produtoService.updateProduct(id, produto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id){
        produtoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
