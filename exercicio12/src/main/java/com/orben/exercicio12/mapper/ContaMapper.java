package com.orben.exercicio12.mapper;

import com.orben.exercicio12.dto.ContaDTO;
import com.orben.exercicio12.model.Conta;

public class ContaMapper {
    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getNome());
    }
}
