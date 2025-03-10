package com.br.api_web.models;

public class Categoria {
    private Long id;
    private String nome;
    private String descricao;


    public Categoria(){}

    public Categoria(Long id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
