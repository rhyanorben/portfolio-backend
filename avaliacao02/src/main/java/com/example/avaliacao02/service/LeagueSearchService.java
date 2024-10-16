package com.example.avaliacao02.service;

import com.example.avaliacao02.models.League.ApiResponseLeague;
import com.example.avaliacao02.models.League.League;
import com.example.avaliacao02.models.League.LeagueEntity;
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
public class LeagueSearchService {

    private static final Logger logger = LoggerFactory.getLogger(LeagueSearchService.class);

    public List<LeagueEntity> buscarLigas(String nomeLiga){
        logger.info("Iniciando a busca pelo nome da liga: {}", nomeLiga);
        String baseUrl = "https://v3.football.api-sports.io/leagues?name=";
        baseUrl += nomeLiga;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "c48e7f3cdbd90e65d6ad8b89cb2d1d9b");
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {

            ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
            logger.info("Resposta recebida da API: {}", response.getBody());

            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponseLeague apiResponse = objectMapper.readValue(response.getBody(), ApiResponseLeague.class);
            logger.info("Resposta da API processada corretamente: {}", apiResponse.getResponse());

            List<LeagueEntity> ligas = new ArrayList<>();
            for(League league : apiResponse.getResponse()) {
                LeagueEntity liga = new LeagueEntity(
                        league.getLeague().getId(),
                        league.getLeague().getName(),
                        league.getLeague().getType(),
                        league.getCountry().getName()
                );
                ligas.add(liga);
            }

            return ligas;

        } catch (Exception e) {
            logger.error("Erro ao buscar os detalhes da liga: {}", e);
            return Collections.emptyList();
        }
    }
}
