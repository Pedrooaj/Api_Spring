package com.br.api_web.DTO.Response;

public class CategoriaResDTO {
     private Long id;
     private String nome;
     private String descricao;

     public CategoriaResDTO(Long id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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
