// Define o pacote onde a classe Controller está localizada.
// Pacotes servem para organizar as classes da aplicação.
package com.example.FipeAPI.controller;


// Importa a classe Service, que contém a lógica de negócio
// utilizada pelo Controller.
import com.example.FipeAPI.service.Service;

// Importa a anotação @PathVariable.
// Ela permite pegar valores que estão presentes na URL
// e passá-los como parâmetros para um método.
import org.springframework.web.bind.annotation.PathVariable;

// Importa a anotação @GetMapping.
// Ela é usada para criar endpoints que respondem a requisições HTTP GET.
import org.springframework.web.bind.annotation.GetMapping;

// Importa a anotação @RestController.
// Ela informa ao Spring que esta classe é um Controller REST.
import org.springframework.web.bind.annotation.RestController;


// Indica que esta classe será um Controller REST.
//
// Isso significa que o Spring vai gerenciar essa classe
// e que seus métodos poderão responder a requisições HTTP.
//
// Além disso, os valores retornados pelos métodos são enviados
// diretamente como resposta da API.
@RestController
public class Controller {

    // Cria um objeto da classe Service.
    //
    // Esse objeto será utilizado pelo Controller para chamar
    // os métodos responsáveis pela lógica da aplicação.
    //
    // ATENÇÃO:
    // Em aplicações Spring, normalmente não fazemos isso com "new Service()".
    // O mais comum é utilizar injeção de dependência com @Autowired
    // ou, preferencialmente, através de um construtor.
    Service service = new Service();

    @GetMapping("/")
    public String home() {
        return "Para consultar os dados do carro desejado, siga do seguinte caminho:\n" +
                "1 - /marcas para consultar as marcas existentes para consulta.\n" +
                "2 - /modelos/(número da marca desejada) para consultar os modelos da marca\n" +
                "3 - /anos/(número da marca)/(número do modelo) para consultar os anos desse modelo\n" +
                "4 - /valor/(número da marca)/(número do modelo)/(ano desejado) para consultar o  valor da fipe do modelo desajado no ano desejado.";
    }

    // @GetMapping define um endpoint HTTP do tipo GET.
    //
    // Quando alguém acessar:
    //
    // GET /marcas
    //
    // o Spring executará o método consultarMarcas().
    @GetMapping("/marcas")

    // Declara o método responsável por consultar as marcas.
    //
    // "public": o método pode ser acessado pelo Spring.
    // "String": o método retorna uma String.
    // "consultarMarcas": nome do método.
    public String consultarMarcas(){

        // Chama o método consultarMarcas() da classe Service
        // e retorna o resultado para quem fez a requisição HTTP.
        return service.consultarMarcas();
    }


    // Cria outro endpoint HTTP GET.
    //
    // A URL possui {marca}, que representa uma variável
    // que será recebida através da URL.
    //
    // Exemplo:
    // GET /modelos/1
    //
    // Nesse caso, o valor de "marca" será 1.
    @GetMapping("/modelos/{marca}")

    // Método responsável por consultar os modelos de uma marca.
    //
    // @PathVariable int marca:
    // pega o valor de {marca} que veio na URL
    // e coloca dentro da variável "marca".
    //
    // Exemplo:
    // /modelos/1
    //
    // marca = 1
    public String consultarModelos(@PathVariable int marca){

        // Envia o código da marca para o Service.
        //
        // O Service será responsável por executar a lógica
        // necessária para consultar os modelos.
        //
        // Depois, o resultado é retornado pela API.
        return service.consultarModelos(marca);
    }


    // Cria um endpoint GET para consultar os anos
    // disponíveis para determinado modelo.
    //
    // A URL possui duas variáveis:
    // {marca} e {modelo}.
    //
    // Exemplo:
    // GET /anos/1/10
    @GetMapping("/anos/{marca}/{modelo}")

    // Método responsável por consultar os anos.
    //
    // @PathVariable int marca:
    // pega o valor de {marca} da URL.
    //
    // @PathVariable int modelo:
    // pega o valor de {modelo} da URL.
    public String consultarAnos(
            @PathVariable int marca,
            @PathVariable int modelo){

        // Passa a marca e o modelo para o Service.
        //
        // O Service realiza a consulta e retorna o resultado.
        return service.consultarAnos(marca, modelo);
    }


    // Cria um endpoint GET para consultar o valor de um veículo.
    //
    // A URL possui três variáveis:
    // {marca}, {modelo} e {ano}.
    //
    // Exemplo:
    // GET /valor/1/10/2024
    @GetMapping("/valor/{marca}/{modelo}/{ano}")

    // Método responsável por consultar o valor do veículo.
    //
    // @PathVariable int marca:
    // pega o código da marca da URL.
    //
    // @PathVariable int modelo:
    // pega o código do modelo da URL.
    //
    // @PathVariable String ano:
    // pega o ano da URL.
    //
    // O ano está como String porque a API da FIPE pode trabalhar
    // com valores de ano que possuem formatos específicos.
    public String consultarValor(
            @PathVariable int marca,
            @PathVariable int modelo,
            @PathVariable String ano){

        // Envia marca, modelo e ano para o Service.
        //
        // O Service executa a lógica da consulta
        // e o resultado é devolvido ao cliente da API.
        return service.consultarValor(marca, modelo, ano);
    }
}