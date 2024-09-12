package com.example.exemplo_semana05;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OlaController {

    @RequestMapping("/mundo")
    @GetMapping("/ola")
    public String olaMundo(@RequestParam String aluno, @RequestParam String sobrenome) {
        return "Olá, " + aluno + " " + sobrenome + "!"; // http://127.0.0.1:8080/ola?aluno=Rhyan&sobrenome=Orben
    }

    @GetMapping("/ola-mundo")
    public String olaMundo() {
        return "Olá, Mundo!"; // http://127.0.0.1:8080/ola
    }
}