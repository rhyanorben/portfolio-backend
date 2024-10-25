package com.example.demo_turma04.mappers;

import com.example.demo_turma04.dtos.JogadorResponseDto;
import com.example.demo_turma04.models.JogadorEntity;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {

    public JogadorResponseDto toDto(JogadorEntity jogador){
        return new JogadorResponseDto(
                jogador.getApelido(),
                jogador.getHabilidade()
        );
    }

}
