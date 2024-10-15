package com.example.avaliacao02.GameIdService;

import com.example.avaliacao02.model.Game;

import com.example.avaliacao02.service.ApiResponse;
import com.example.avaliacao02.service.Fixture;
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
public class GameIdService {

    private static final Logger logger = LoggerFactory.getLogger(GameIdService.class);
    private final String apiUrl = "https://v3.football.api-sports.io";
    private final String apiKey = "c48e7f3cdbd90e65d6ad8b89cb2d1d9b";

    public List<Game> buscarDetalhesJogo(int id_jogo){
        logger.info("Iniciando busca por detalhes do jogo com ID: {}", id_jogo);
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "/fixtures?id=" + id_jogo;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        logger.info("Resposta recebida da API: {}", response.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponse apiResponse = null;

        try {
            apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
            logger.info("Resposta da API processada corretamente: {}", apiResponse.getResponse());

            List<Game> jogos = new ArrayList<>();
            for (Fixture fixture: apiResponse.getResponse()) {
                Game jogo = new Game(
                        fixture.getFixture().getDate(),
                        fixture.getTeams().getHome().getName(),
                        fixture.getTeams().getAway().getName(),
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

