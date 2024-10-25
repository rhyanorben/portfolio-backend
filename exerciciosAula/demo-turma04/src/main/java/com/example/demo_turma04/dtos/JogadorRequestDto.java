package com.example.demo_turma04.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogadorRequestDto(
    @NotBlank(message = "Nome não deve estar em branco") String nome,
    @NotBlank(message = "Apelido não deve estar em branco") String apelido,
    @NotBlank(message = "Posição não deve estar em branco") String posicao,
    @Min(value = 10, message = "Idade deve ser maior que 10.") @Max(value = 75, message = "Idade deve ser no máximo 75") Integer idade
) {}



