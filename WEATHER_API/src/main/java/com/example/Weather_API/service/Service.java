package com.example.Weather_API.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class Service {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();
    private JsonNode buscarCidade(String cidade) throws Exception {
        String url = UriComponentsBuilder
                .fromUriString("https://geocoding-api.open-meteo.com/v1/search")
                .queryParam("name", cidade)
                .queryParam("count", 10)
                .queryParam("language", "pt")
                .queryParam("format", "json")
                .queryParam("countryCode", "BR")
                .build()
                .toUriString();
        ResponseEntity<String> resposta =
                restTemplate.getForEntity(url, String.class);
        if (resposta.getBody() == null) {
            throw new Exception("Resposta vazia da API de localização");
        }
        JsonNode json = mapper.readTree(resposta.getBody());
        if (!json.has("results") || !json.get("results").isArray()) {
            throw new Exception("Cidade não encontrada");
        }
        JsonNode resultados = json.get("results");
        if (resultados.isEmpty()) {
            throw new Exception("Cidade não encontrada no Brasil");
        }
        return resultados.get(0);
    }
    private JsonNode buscarClima(String cidade) throws Exception {
        JsonNode localizacao = buscarCidade(cidade);
        double latitude =
                localizacao.get("latitude").asDouble();
        double longitude =
                localizacao.get("longitude").asDouble();
        String url = UriComponentsBuilder
                .fromUriString("https://api.open-meteo.com/v1/forecast")
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam(
                        "current",
                        "temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m"
                )
                .queryParam(
                        "daily",
                        "temperature_2m_max,temperature_2m_min"
                )
                .queryParam("timezone", "auto")
                .build()
                .toUriString();
        ResponseEntity<String> resposta =
                restTemplate.getForEntity(url, String.class);
        if (resposta.getBody() == null) {
            throw new Exception("Resposta vazia da API de clima");
        }
        return mapper.readTree(resposta.getBody());
    }
    public String consultarTemperatura(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            double temperatura = json
                    .get("current")
                    .get("temperature_2m")
                    .asDouble();
            return "Temperatura: " + temperatura + " °C";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarUmidade(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            int umidade = json
                    .get("current")
                    .get("relative_humidity_2m")
                    .asInt();
            return "Umidade: " + umidade + "%";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarVelVento(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            double velocidade = json
                    .get("current")
                    .get("wind_speed_10m")
                    .asDouble();
            return "Velocidade do vento: "
                    + velocidade
                    + " km/h";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarDirecaoVento(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            int direcao = json
                    .get("current")
                    .get("wind_direction_10m")
                    .asInt();
            return "Direção do vento: "
                    + direcao
                    + "°";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarTemperaturaMax(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            double maxima = json
                    .get("daily")
                    .get("temperature_2m_max")
                    .get(0)
                    .asDouble();
            return "Temperatura máxima: "
                    + maxima
                    + " °C";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarTemperaturaMin(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            double minima = json
                    .get("daily")
                    .get("temperature_2m_min")
                    .get(0)
                    .asDouble();
            return "Temperatura mínima: "
                    + minima
                    + " °C";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarLocalizacao(String cidade) {
        try {
            JsonNode localizacao = buscarCidade(cidade);
            return "Cidade: "
                    + localizacao.get("name").asText()
                    + "\nLatitude: "
                    + localizacao.get("latitude").asDouble()
                    + "\nLongitude: "
                    + localizacao.get("longitude").asDouble();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
    public String consultarHorario(String cidade) {
        try {
            JsonNode json = buscarClima(cidade);
            return "Horário: "
                    + json.get("current")
                    .get("time")
                    .asText();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}