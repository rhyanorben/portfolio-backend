package com.example.demo_turma04.controller;

import com.example.demo_turma04.dtos.JogadorRequestDto;
import com.example.demo_turma04.dtos.JogadorResponseDto;
import com.example.demo_turma04.models.JogadorEntity;
import com.example.demo_turma04.services.JogadorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping("/jogadores")
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorResponseDto inserirJogador(@RequestBody JogadorRequestDto jogador){
        return jogadorService.inserirJogador(jogador);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String erroValidacao(HttpServletRequest req, MethodArgumentNotValidException ex) {
        return ex.getAllErrors().get(0).getDefaultMessage();
    }

}
