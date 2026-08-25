package main.java.com.example.Weather_API.controllers;

public class Controller {
    Service service = new Service();

    @GetMapping("/temperatura")
    public String consultarTemperatura(){
        return service.consultarTemperatura();
    }

    @GetMapping("/unidade")
    public String consultarUmidade(){
        return service.consultarUmidade();
    }

    @GetMapping("/velocidade_vento")
    public String consultarVelocidadeVento(){
        return service.consultarVelVento();
    }

    @GetMapping("/direcao_vento")
    public String consultarDirecaoVento(){
        return service.consultarDirecaoVento();
    }

    @GetMapping("/temperatura_max")
    public String consultarTemperaturaMax(){
        return service.consultarTemperaturaMax();
    }

    @GetMapping("/temperatura_min")
    public String consultarTemperaturaMin(){
        return service.consultarTemperaturaMin();
    }

    @GetMapping("/localizacao")
    public String consultarLocalizacao(){
        return service.consultarLocalizacao();
    }

    @GetMapping("/temperatura_max")
    public String consultarHorario(){
        return service.consultarHorario();
    }
}
