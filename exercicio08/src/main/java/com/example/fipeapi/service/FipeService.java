package com.exemplo.fipeapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FipeService {

    private static final String API_FIPE_URL = "https://api.fipe.org/car/{marca}/{modelo}/{ano}";

    public Map<String, Object> consultarFipe(String marca, String modelo, int ano) {
        RestTemplate restTemplate = new RestTemplate();

        // Monta a URL para a requisição à API FIPE
        String url = API_FIPE_URL.replace("{marca}", marca)
                .replace("{modelo}", modelo)
                .replace("{ano}", String.valueOf(ano));

        // Faz a requisição à API FIPE
        Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);

        // Exemplo de retorno formatado
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("valor", resposta.get("valor"));
        resultado.put("mes", resposta.get("mesReferencia"));

        return resultado;
    }
}
