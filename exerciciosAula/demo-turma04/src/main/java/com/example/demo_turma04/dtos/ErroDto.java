package com.example.demo_turma04.dtos;

import java.util.List;

public record ErroDto(
    Integer status,
    List<String> razoes
) {
}
