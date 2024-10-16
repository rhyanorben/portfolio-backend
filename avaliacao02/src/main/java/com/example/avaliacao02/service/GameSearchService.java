package com.example.avaliacao02.service;

import com.example.avaliacao02.models.Fixture.ApiResponseFixture;
import com.example.avaliacao02.models.Fixture.Fixture;
import com.example.avaliacao02.models.Fixture.GameEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameSearchService {

    private static final Logger logger = LoggerFactory.getLogger(GameSearchService.class);

    public List<GameEntity> buscarPartidas(int idLiga, int idTime) {
        String baseUrl = "https://v3.football.api-sports.io/fixtures?live=all";

        if(idLiga != 0){
            baseUrl += "&league=" + idLiga;
        }

        if(idTime != 0){
           baseUrl += "&team=" + idTime;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "c48e7f3cdbd90e65d6ad8b89cb2d1d9b");
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
        logger.info("Resposta recebida da API: {}", response.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseFixture apiResponse = null;

        try {
            apiResponse = objectMapper.readValue(response.getBody(), ApiResponseFixture.class);
            logger.info("Resposta da API processada corretamente: {}", apiResponse.getResponse());

            List<GameEntity> jogos = new ArrayList<>();
            for (Fixture fixture : apiResponse.getResponse()) {
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
