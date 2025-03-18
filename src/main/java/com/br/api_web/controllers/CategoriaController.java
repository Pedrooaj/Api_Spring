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

import com.br.api_web.DTO.Request.CategoriaReqDTO;
import com.br.api_web.DTO.Response.CategoriaResDTO;
import com.br.api_web.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }   

    @GetMapping
    public ResponseEntity<List<CategoriaResDTO>> listarCategorias(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResDTO> buscarPorID(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CategoriaResDTO> criarCategoria(@RequestBody CategoriaReqDTO categoria){
        return ResponseEntity.ok(categoriaService.criarCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResDTO> editarCategoria(@PathVariable Long id, @RequestBody CategoriaReqDTO categoria){
        return ResponseEntity.ok(categoriaService.atualizaCategoria(id, categoria));
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);   
    }
}
