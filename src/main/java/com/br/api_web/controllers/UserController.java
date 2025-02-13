package com.br.api_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define a classe como controller
@RequestMapping("/user") // Define o nome da rota do controller
public class UserController {

    // define o metodo como get no controller
    @GetMapping
    public String helloworld(){
        return "Hello world";
    }
}
