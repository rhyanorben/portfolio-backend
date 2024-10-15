package com.example.demo_semana08.controllers;

import com.example.demo_semana08.models.Pessoa;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {
    @GetMapping("/mundo")
    public String Ola(@RequestParam String nome, @RequestParam String sobrenome) {
        return "Olá, " + nome + " " + sobrenome + "!";
    }

    @PostMapping("/mundo")
    public String mundo(@RequestBody Pessoa pessoa) {
        return "Olá, " + pessoa.getNome() + " " + pessoa.getSobrenome() + "!";
    }
}
