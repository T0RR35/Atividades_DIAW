package com.example.Weather_API.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Service {

    private static final String BASE_URL =
            "https://api.open-meteo.com/v1/forecast?latitude=-19.9208&longitude=-43.9378";
    Gson gson = new Gson(); 

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

    public String getValor(String conjunto, String chave, String json){
        JsonElement element = JsonParser.parseString(json);
        JsonObject root = element.getAsJsonObject();

        JsonObject dataObj;
        if (conjunto.equals("")){
            dataObj = root.getAsJsonObject();
        }else{
            dataObj = root.getAsJsonObject(conjunto);
        }
        
        String res = "";
        if (dataObj != null) {
            if(dataObj.get(chave).isJsonArray()){
                JsonArray array = dataObj.get(chave).getAsJsonArray();
                res = gson.toJson(array.get(0));
            }else{
                res = dataObj.get(chave).getAsString();
            }
        }
        return res;
    }

    public String consultarTemperatura() {
        String json = consultarURL(BASE_URL + "&current=temperature_2m");
        return getValor("current", "temperature_2m", json);
    }

    public String consultarUmidade() {
        String json =  consultarURL(BASE_URL + "&current=relative_humidity_2m");
        return getValor("current", "relative_humidity_2m", json);
    }

    public String consultarVelVento() {
        String json = consultarURL(BASE_URL + "&current=wind_speed_10m");
        return getValor("current", "wind_speed_10m", json);
    }

    public String consultarDirecaoVento() {
        String json = consultarURL(BASE_URL + "&current=wind_direction_10m");
        return getValor("current", "wind_direction_10m", json);
    }

    public String consultarTemperaturaMax() {
        String json = consultarURL(BASE_URL + "&daily=temperature_2m_max");
        return getValor("daily", "temperature_2m_max", json);
    }

    public String consultarTemperaturaMin() {
        String json = consultarURL(BASE_URL + "&daily=temperature_2m_min");
        return getValor("daily", "temperature_2m_min", json);
    }

    public String consultarLocalizacao() {
        String json = consultarURL(BASE_URL);
        String lat = getValor("", "latitude", json);
        String lon = getValor("", "longitude", json);

        return "Latidude: " + lat + "\nLongitude: " + lon;
    }

    public String consultarHorario() {
        String json = consultarURL(BASE_URL + "&current=time");
        return getValor("current", "time", json);
    }
}