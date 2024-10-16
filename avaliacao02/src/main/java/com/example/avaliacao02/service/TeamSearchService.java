package com.example.avaliacao02.service;

import com.example.avaliacao02.models.Team.ApiResponseTeam;
import com.example.avaliacao02.models.Team.Team;
import com.example.avaliacao02.models.Team.TeamEntity;
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
public class TeamSearchService {

    private static final Logger logger = LoggerFactory.getLogger(TeamSearchService.class);

    public List<TeamEntity> buscarTimes(String nomeTime){
        logger.info("Iniciando a busca pelo nome do time: {}", nomeTime);
        String baseUrl = "https://v3.football.api-sports.io/teams?name=";
        baseUrl += nomeTime;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "c48e7f3cdbd90e65d6ad8b89cb2d1d9b");
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {

            ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
            logger.info("Resposta recebida da API: {}", response.getBody());

            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponseTeam apiResponse = objectMapper.readValue(response.getBody(), ApiResponseTeam.class);
            logger.info("Resposta da API processada corretamente: {}", apiResponse.getResponse());

            List<TeamEntity> times = new ArrayList<>();
            for(Team team : apiResponse.getResponse()) {
                TeamEntity time = new TeamEntity(
                        team.getTeam().getId(),
                        team.getTeam().getName(),
                        team.getTeam().getCountry()
                );
                times.add(time);
            }

            return times;

        } catch (Exception e) {
            logger.error("Erro ao buscar os detalhes do time: {}", e);
            return Collections.emptyList();
        }
    }
}
