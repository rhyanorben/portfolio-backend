package com.exemplo.fipeapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class FipeService {

    private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

    public Map<String, Object> consultarFipe(String marca, String modelo, int ano) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Obter código da marca
        String marcasUrl = BASE_URL;
        Map[] marcas = restTemplate.getForObject(marcasUrl, Map[].class);
        String codigoMarca = obterCodigoMarca(marcas, marca);

        // 2. Obter código do modelo da marca
        String modelosUrl = BASE_URL + "/" + codigoMarca + "/modelos";
        Map<String, Object> modelosResponse = restTemplate.getForObject(modelosUrl, Map.class);
        Map[] modelos = (Map[]) modelosResponse.get("modelos");
        String codigoModelo = obterCodigoModelo(modelos, modelo);

        // 3. Obter código do ano
        String anosUrl = BASE_URL + "/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        Map[] anos = restTemplate.getForObject(anosUrl, Map[].class);
        String codigoAno = obterCodigoAno(anos, ano);

        // 4. Obter valor FIPE
        String valorUrl = BASE_URL + "/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno;
        Map<String, Object> valorFipeResponse = restTemplate.getForObject(valorUrl, Map.class);

        // 5. Retornar o valor formatado
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("valor", valorFipeResponse.get("Valor"));
        resultado.put("mes", valorFipeResponse.get("MesReferencia"));

        return resultado;
    }

    private String obterCodigoMarca(Map[] marcas, String nomeMarca) {
        for (Map marca : marcas) {
            if (marca.get("nome").toString().equalsIgnoreCase(nomeMarca)) {
                return marca.get("codigo").toString();
            }
        }
        throw new IllegalArgumentException("Marca não encontrada: " + nomeMarca);
    }

    private String obterCodigoModelo(Map[] modelos, String nomeModelo) {
        for (Map modelo : modelos) {
            if (modelo.get("nome").toString().equalsIgnoreCase(nomeModelo)) {
                return modelo.get("codigo").toString();
            }
        }
        throw new IllegalArgumentException("Modelo não encontrado: " + nomeModelo);
    }

    private String obterCodigoAno(Map[] anos, int ano) {
        String anoStr = String.valueOf(ano);
        for (Map anoMap : anos) {
            if (anoMap.get("nome").toString().contains(anoStr)) {
                return anoMap.get("codigo").toString();
            }
        }
        throw new IllegalArgumentException("Ano não encontrado: " + ano);
    }
}
