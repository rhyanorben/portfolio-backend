package com.example.demo_turma04.services;

import com.example.demo_turma04.dtos.JogadorRequestDto;
import com.example.demo_turma04.dtos.JogadorResponseDto;
import com.example.demo_turma04.mappers.JogadorMapper;
import com.example.demo_turma04.models.JogadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    List<JogadorEntity> jogadores = new ArrayList<>();
    @Autowired
    JogadorMapper jogadorMapper;

    public JogadorResponseDto inserirJogador(JogadorRequestDto jogadorRequestDto) {
        Integer habilidadeAleatoria = new Random().nextInt(1, 100);
        JogadorEntity jogador = new JogadorEntity();
        jogador.setNome(jogadorRequestDto.nome());
        jogador.setApelido(jogadorRequestDto.apelido());
        jogador.setPosicao(jogadorRequestDto.posicao());
        jogador.setIdade(jogadorRequestDto.idade());
        jogador.setHabilidade(habilidadeAleatoria);
        //Salvar o jogador
        jogadores.add(jogador);
        return jogadorMapper.toDto(jogador);
    }

}
