package com.br.api_web.DTO.Response;

public class ProdutoResDTO {
    private Long id;
    private String nome;
    private double preco;
    private String nSerie;

    public ProdutoResDTO() {}
    public ProdutoResDTO(Long id, String nome, double preco, String nSerie) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public String getnSerie() {
        return nSerie;
    }
}
