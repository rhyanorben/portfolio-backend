package com.example.avaliacao02.service;

import com.example.avaliacao02.models.Fixture.ApiResponseFixture;
import com.example.avaliacao02.models.Fixture.Fixture;
import com.example.avaliacao02.models.Fixture.GameEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Game4IdService {

    private static final Logger logger = LoggerFactory.getLogger(Game4IdService.class);
    private final String apiUrl = "https://v3.football.api-sports.io";
    private final String apiKey = "c48e7f3cdbd90e65d6ad8b89cb2d1d9b";

    public List<GameEntity> buscarDetalhesJogo(int id_jogo){
        logger.info("Iniciando busca por detalhes do jogo com ID: {}", id_jogo);

        String url = apiUrl + "/fixtures?id=" + id_jogo;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        logger.info("Resposta recebida da API: {}", response.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseFixture apiResponse = null;

        try {
            apiResponse = objectMapper.readValue(response.getBody(), ApiResponseFixture.class);
            logger.info("Resposta da API processada corretamente: {}", apiResponse.getResponse());

            List<GameEntity> jogos = new ArrayList<>();
            for (Fixture fixture: apiResponse.getResponse()) {
                GameEntity jogo = new GameEntity(
                        fixture.getFixture().getDate(),
                        fixture.getLeague().getName(),
                        fixture.getFixture().getStatus().getElapsed(),
                        fixture.getFixtureTeams().getHome().getName(),
                        fixture.getFixtureTeams().getAway().getName(),
                        fixture.getGoals().getHome(),
                        fixture.getGoals().getAway(),
                        fixture.getFixture().getStatus().getLongStatus()
                );
                jogos.add(jogo);
            }

        return jogos;

        } catch (Exception e) {
            logger.error("Erro ao buscar os detalhes do jogo: ", e);
            return Collections.emptyList();
        }
    }
}

