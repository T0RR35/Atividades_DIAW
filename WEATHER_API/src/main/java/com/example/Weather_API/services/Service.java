package main.java.com.example.Weather_API.services;


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

    @GetMapping("/temperatura")
    public String consultarTemperatura(){
        return consultarURL(BASE_URL + "&current=temperature_2m");
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
        return consultarURL(BASE_URL + "&daily=temperature_2m_min");
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
