/*  Repository e responsavel por tratar dados da aplicação. 
Ele esta diretamente ligado a banco de dados mas não necessariamente e o banco de dados.
*/
package com.br.api_web.repository;
import com.br.api_web.models.Produto;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
    private static List<Produto> produtos = new ArrayList<>();
    private Long nextId = 1L;


    public List<Produto> findAll(){
        return produtos;
    }

    // Optional para retornar nulo ou produto
    public Optional<Produto> findById(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Produto save(Produto produto){
        produto.setId(nextId++);
        produtos.add(produto);  
        return produto;
    }

    public Produto update(Produto produto){
        return produtos.stream()
                .filter(p -> p.getId().equals(produto.getId()))
                .findFirst().map(p -> {
                    p.setNome(produto.getNome());
                    p.setPreco(produto.getPreco());
                    p.setnSerie(produto.getnSerie());
                    return p;
                }).orElseThrow(() -> new RuntimeException("Produto não encontrado para atualização"));
    }

    public void deleteById(Long id){
        produtos.removeIf(p -> p.getId().equals(id));
    }
}
