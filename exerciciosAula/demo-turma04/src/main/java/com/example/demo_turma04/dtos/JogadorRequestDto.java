package com.example.demo_turma04.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogadorRequestDto(
    @NotBlank String nome,
    @NotNull String apelido,
    @NotNull String posicao,
    @Min(value = 10) @Max(value = 75) Integer idade
) {}



