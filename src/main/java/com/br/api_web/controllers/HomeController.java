package com.br.api_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define a classe como controller
@RequestMapping("/") // Define o nome da rota do controller
public class HomeController {

    // define o metodo como get no controller
    @GetMapping
    public String helloworld(){
        return "Hello world!";
    }

    // Utilizando path para puxar na função a variavel
    @GetMapping("/{nome}")
    public String helloUser(@PathVariable String nome){
        return "Hello, " + nome + " nice to meet you (:";
    }
}
