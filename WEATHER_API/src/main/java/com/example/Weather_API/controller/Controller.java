package com.example.Weather_API.controller;

import com.example.Weather_API.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    Service service = new Service();

    @GetMapping("/temperatura")
    public String consultarTemperatura() {
        return service.consultarTemperatura();
    }

    @GetMapping("/umidade")
    public String consultarUmidade() {
        return service.consultarUmidade();
    }

    @GetMapping("/velocidade_vento")
    public String consultarVelocidadeVento() {
        return service.consultarVelVento();
    }

    @GetMapping("/direcao_vento")
    public String consultarDirecaoVento() {
        return service.consultarDirecaoVento();
    }

    @GetMapping("/temperatura_max")
    public String consultarTemperaturaMax() {
        return service.consultarTemperaturaMax();
    }

    @GetMapping("/temperatura_min")
    public String consultarTemperaturaMin() {
        return service.consultarTemperaturaMin();
    }

    @GetMapping("/localizacao")
    public String consultarLocalizacao() {
        return service.consultarLocalizacao();
    }

    @GetMapping("/horario")
    public String consultarHorario() {
        return service.consultarHorario();
    }
}