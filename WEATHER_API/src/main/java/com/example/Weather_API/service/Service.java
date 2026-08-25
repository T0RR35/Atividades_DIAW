package com.example.Weather_API.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {

    private static final String BASE_URL =
            "https://api.open-meteo.com/v1/forecast?latitude=-19.9208&longitude=-43.9378";

    private String consultarURL(String apiUrl) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return "Falha ao obter dados. Código de status: "
                    + responseEntity.getStatusCode();
        }
    }

    public String consultarTemperatura() {
        return consultarURL(BASE_URL + "&current=temperature_2m");
    }

    public String consultarUmidade() {
        return consultarURL(BASE_URL + "&current=relative_humidity_2m");
    }

    public String consultarVelVento() {
        return consultarURL(BASE_URL + "&current=wind_speed_10m");
    }

    public String consultarDirecaoVento() {
        return consultarURL(BASE_URL + "&current=wind_direction_10m");
    }

    public String consultarTemperaturaMax() {
        return consultarURL(BASE_URL + "&daily=temperature_2m_max");
    }

    public String consultarTemperaturaMin() {
        return consultarURL(BASE_URL + "&daily=temperature_2m_min");
    }

    public String consultarLocalizacao() {
        return "Latitude: -19.9208, Longitude: -43.9378";
    }

    public String consultarHorario() {
        return consultarURL(BASE_URL + "&current=temperature_2m");
    }
}