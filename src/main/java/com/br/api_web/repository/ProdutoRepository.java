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

    // Optional para retornar nullo ou produto
    public Optional<Produto> findById(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

}
