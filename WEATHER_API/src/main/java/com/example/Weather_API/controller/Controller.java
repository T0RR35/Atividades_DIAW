package com.example.Weather_API.controller;

import com.example.Weather_API.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Service service = new Service();

    @GetMapping("/temperatura")
    public String temperatura(@RequestParam String cidade) {
        return service.consultarTemperatura(cidade);
    }

    @GetMapping("/umidade")
    public String umidade(@RequestParam String cidade) {
        return service.consultarUmidade(cidade);
    }

    @GetMapping("/velocidade_vento")
    public String velocidadeVento(@RequestParam String cidade) {
        return service.consultarVelVento(cidade);
    }

    @GetMapping("/direcao_vento")
    public String direcaoVento(@RequestParam String cidade) {
        return service.consultarDirecaoVento(cidade);
    }

    @GetMapping("/temperatura_max")
    public String temperaturaMax(@RequestParam String cidade) {
        return service.consultarTemperaturaMax(cidade);
    }

    @GetMapping("/temperatura_min")
    public String temperaturaMin(@RequestParam String cidade) {
        return service.consultarTemperaturaMin(cidade);
    }

    @GetMapping("/localizacao")
    public String localizacao(@RequestParam String cidade) {
        return service.consultarLocalizacao(cidade);
    }

    @GetMapping("/horario")
    public String horario(@RequestParam String cidade) {
        return service.consultarHorario(cidade);
    }
}