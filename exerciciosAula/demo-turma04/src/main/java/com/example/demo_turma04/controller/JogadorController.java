package com.example.demo_turma04.controller;

import com.example.demo_turma04.dtos.ErroDto;
import com.example.demo_turma04.dtos.JogadorRequestDto;
import com.example.demo_turma04.dtos.JogadorResponseDto;
import com.example.demo_turma04.services.JogadorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping("/jogadores")
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorResponseDto inserirJogador(@RequestBody @Valid JogadorRequestDto jogador){
        return jogadorService.inserirJogador(jogador);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErroDto erroValidacao(HttpServletRequest req, MethodArgumentNotValidException ex) {
                List<String> mensagensErro = ex.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
                return new ErroDto(400, mensagensErro);
    }

}
