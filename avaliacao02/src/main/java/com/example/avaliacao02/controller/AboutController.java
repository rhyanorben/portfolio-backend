package com.example.avaliacao02.controller;

import com.example.avaliacao02.model.Estudante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @GetMapping("/sobre")
    public Estudante getEstudante(){
        Estudante estudante = new Estudante("Rhyan Willemann Orben", "Buscador de jogos");
        return estudante;
    }

}
