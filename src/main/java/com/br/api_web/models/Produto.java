
// Modelo do objeto

package com.br.api_web.models;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private String nSerie;
    
    
    public Produto(){

    }

    public Produto(Long id, String nome, double preco, String nSerie){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.nSerie = nSerie;

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


    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }
}
