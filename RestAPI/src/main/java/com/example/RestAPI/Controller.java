package com.example.RestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

class EnderecoDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }

    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
}

@RestController
public class Controller {
    @GetMapping("/test")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/diaw")
    public String diaw(){
        return "Esse eh meu segundo endpoint";
    }

    @GetMapping("/api_terceira")
    public String terceira(){
        String url = "https://viacep.com.br/ws/" + "30865390" + "/json/";
        
        RestTemplate restTemplate = new RestTemplate();
        EnderecoDTO endereco = restTemplate.getForObject(url, EnderecoDTO.class);
        
        return endereco.getCep();
    }
}
