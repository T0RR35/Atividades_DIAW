package com.example.Weather_API.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

//https://api.open-meteo.com/v1/forecast?latitude=-19.9208&longitude=-43.9378&daily=temperature_2m_min,temperature_2m_max&current=temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m,rain
public class Service {
    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast?latitude=-19.9208&longitude=-43.9378";
    
    private String consultarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }

    public String consultarTemperatura(){
        return consultarURL(BASE_URL + "&current=temperature_2m");
    }

}
