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
public class SearchLeagueId {

    private static final Logger logger = LoggerFactory.getLogger(SearchLeagueId.class);
    private final String apiUrl = "https://v3.football.api-sports.io";
    private final String apiKey = "c48e7f3cdbd90e65d6ad8b89cb2d1d9b";

    public int searchLeagueId(String nomeLiga){

        logger.info("Iniciando busca do ID pelo nome da liga: {}", nomeLiga);
        String url = apiUrl + "/leagues?search=" + nomeLiga;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        try{

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            logger.info("Resposta recebida da API: {}", response.getBody());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.getBody());


            if (root.path("response").size() > 0) {
                int idLiga = root.path("response").get(0).path("league").path("id").asInt();
                return idLiga;
            } else {
                logger.error("Nenhum time encontrado com o nome: {}", nomeLiga);
                return -1; // Retorne -1 ou lance uma exceção personalizada
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar ID do time: {}", e);
            return -1;
        }
    }
}
