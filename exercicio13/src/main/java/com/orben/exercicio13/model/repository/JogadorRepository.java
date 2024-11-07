package com.orben.exercicio13.model.repository;

import com.orben.exercicio13.model.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {}
