package com.br.api_web.DTO.Request;

public class ProdutoReqDTO {
    private String nome;
    private double preco;
    private String numeroSerie;


    public ProdutoReqDTO(){}

    public ProdutoReqDTO(String nome, double preco, String nSerie){
        this.nome = nome;
        this.preco = preco;
        this.numeroSerie = nSerie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setnSerie(String nSerie) {
        this.numeroSerie = nSerie;
    }

    
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public String getnSerie() {
        return numeroSerie;
    }

}
