package com.br.api_web.DTO.Request;

public class CategoriaReqDTO {
    private String nome;
    private String descricao;

    public CategoriaReqDTO(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
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
    public String getNome() {
        return nome;
    }
}
