package com.example.avaliacao02.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SearchTeamId {

    private static final Logger logger = LoggerFactory.getLogger(SearchTeamId.class);
    private final String apiUrl = "https://v3.football.api-sports.io";
    private final String apiKey = "c48e7f3cdbd90e65d6ad8b89cb2d1d9b";

    public int searchTeamId(String nomeTime) {

        logger.info("Iniciando a busca do ID pelo nome do time: {}", nomeTime);
        String url = apiUrl + "/teams?search=" + nomeTime;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            logger.info("Resposta recebida da API: {}", response.getBody());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.getBody());

            if (root.path("response").size() > 0) {
                int idTime = root.path("response").get(0).path("team").path("id").asInt();
                return idTime;
            } else {
                logger.error("Nenhum time encontrado com o nome: {}", nomeTime);
                return -1; // Retorne -1 ou lance uma exceção personalizada
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar ID do time: {}", e);
            return -1;
        }

    }

}
