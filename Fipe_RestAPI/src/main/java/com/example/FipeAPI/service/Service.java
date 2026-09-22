// Define o pacote onde a classe Service está localizada.
// O pacote serve para organizar as classes da aplicação.
package com.example.FipeAPI.service;


// Importa a classe ResponseEntity do Spring.
// ResponseEntity representa uma resposta HTTP completa,
// incluindo o corpo da resposta, o código de status e os headers.
import org.springframework.http.ResponseEntity;

// Importa o RestTemplate.
// Ele permite que nossa aplicação faça requisições HTTP
// para outras APIs.
import org.springframework.web.client.RestTemplate;


// Declara a classe Service.
//
// Essa classe é responsável por concentrar a lógica relacionada
// às consultas que serão feitas na API da FIPE.
public class Service {


    // Declara uma constante que contém a URL base da API da FIPE.
    //
    // "private":
    // só pode ser acessada dentro desta classe.
    //
    // "static":
    // pertence à classe, e não a uma instância específica.
    //
    // "final":
    // seu valor não pode ser alterado depois de definido.
    //
    // Dessa forma, BASE_URL sempre terá:
    //
    // https://fipe.parallelum.com.br/api/v2
    private static final String BASE_URL = "https://fipe.parallelum.com.br/api/v2";


    // Método responsável por fazer uma requisição para uma URL
    // e retornar os dados recebidos.
    //
    // "private":
    // esse método só será utilizado dentro da própria classe Service.
    //
    // "String":
    // indica que o método retornará uma String.
    //
    // "apiUrl":
    // é o endereço da API para o qual será feita a requisição.
    private String consultarURL(String apiUrl) {


        // Cria uma variável chamada "dados".
        //
        // Ela começa com uma String vazia.
        // Posteriormente, receberá o conteúdo retornado pela API
        // ou uma mensagem de erro.
        String dados = "";


        // Cria um objeto RestTemplate.
        //
        // O RestTemplate é uma ferramenta do Spring utilizada
        // para realizar requisições HTTP para outras APIs.
        //
        // Neste caso, vamos utilizá-lo para fazer uma requisição GET.
        RestTemplate restTemplate = new RestTemplate();


        // Faz uma requisição HTTP GET para a URL recebida no parâmetro apiUrl.
        //
        // getForEntity() recebe dois argumentos:
        //
        // 1. apiUrl:
        //    endereço para onde será feita a requisição.
        //
        // 2. String.class:
        //    informa que esperamos receber a resposta como uma String.
        //
        // O resultado é armazenado em um ResponseEntity<String>.
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);


        // Verifica se o código de status HTTP recebido indica sucesso.
        //
        // is2xxSuccessful() retorna true quando o código está
        // na faixa 200-299.
        //
        // Exemplos:
        // 200 OK
        // 201 Created
        // 204 No Content
        if (responseEntity.getStatusCode().is2xxSuccessful()) {


            // Obtém o corpo (body) da resposta HTTP.
            //
            // responseEntity.getBody() contém os dados retornados
            // pela API da FIPE.
            //
            // Esses dados são armazenados na variável "dados".
            dados = responseEntity.getBody();


        } else {


            // Caso a API retorne um código que não seja 2xx,
            // cria uma mensagem informando que houve uma falha.
            //
            // getStatusCode() obtém o código de status HTTP retornado.
            //
            // Por exemplo:
            //
            // Falha ao obter dado. Código de status: 404 NOT_FOUND
            //
            // O operador "+" é utilizado para concatenar
            // diferentes Strings.
            dados = "Falha ao obter dado. Código de status: " + responseEntity.getStatusCode();
        }


        // Retorna os dados obtidos pela API ou a mensagem de erro.
        //
        // O método consultarURL() termina aqui e devolve
        // o resultado para quem o chamou.
        return dados;
    }


    // Método responsável por consultar as marcas de veículos.
    //
    // O método é public porque será chamado pelo Controller.
    //
    // Retorna uma String contendo a resposta da API.
    public String consultarMarcas() {

        // Monta a URL utilizando a constante BASE_URL.
        //
        // BASE_URL:
        // https://fipe.parallelum.com.br/api/v2
        //
        // Depois adicionamos:
        // /cars/brands
        //
        // Resultado:
        // https://fipe.parallelum.com.br/api/v2/cars/brands
        //
        // A URL é enviada para consultarURL(),
        // que realiza a requisição HTTP.
        return consultarURL(BASE_URL + "/cars/brands");
        // v1: return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }


    // Método responsável por consultar os modelos
    // de uma determinada marca.
    //
    // O parâmetro "id" representa o código da marca.
    //
    // Exemplo:
    // se id = 1, será consultada a marca cujo código é 1.
    public String consultarModelos(int id) {

        // Monta a URL utilizando o código da marca.
        //
        // Se id = 1, teremos:
        //
        // BASE_URL + "/cars/brands/" + 1 + "/models"
        //
        // Resultado:
        // https://fipe.parallelum.com.br/api/v2/cars/brands/1/models
        //
        // Depois, a URL é enviada para consultarURL(),
        // que realiza a requisição GET.
        return consultarURL(BASE_URL + "/cars/brands/" + id + "/models");
        // v1: return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+id+"/modelos");
    }


    // Método responsável por consultar os anos disponíveis
    // para determinado modelo de determinada marca.
    //
    // Recebe dois parâmetros:
    //
    // marca:
    // código da marca.
    //
    // modelo:
    // código do modelo.
    public String consultarAnos(int marca, int modelo) {

        // Monta a URL utilizando os códigos da marca e do modelo.
        //
        // Por exemplo:
        //
        // marca = 1
        // modelo = 10
        //
        // A URL será:
        //
        // https://fipe.parallelum.com.br/api/v2/cars/brands/1/models/10/years
        //
        // Depois, a URL é enviada para consultarURL().
        return consultarURL(BASE_URL + "/cars/brands/" + marca + "/models/" + modelo + "/years");
        // v1: return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos");

    }

    // Método responsável por consultar o valor de um veículo.
    //
    // Recebe três informações:
    //
    // marca:
    // código da marca.
    //
    // modelo:
    // código do modelo.
    //
    // ano:
    // ano do veículo.
    //
    // O ano é recebido como String.
    public String consultarValor(int marca, int modelo, String ano) {

        // Monta a URL completa utilizando:
        //
        // - código da marca;
        // - código do modelo;
        // - ano do veículo.
        //
        // Por exemplo:
        //
        // marca = 1
        // modelo = 10
        // ano = "2024-1"
        //
        // A URL ficará semelhante a:
        //
        // https://fipe.parallelum.com.br/api/v2/cars/brands/1/models/10/years/2024-1
        //
        // Depois, essa URL é enviada para consultarURL(),
        // que faz a requisição GET.
        return consultarURL(BASE_URL + "/cars/brands/" + marca + "/models/" + modelo + "/years/" + ano);
        // v1: return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos/"+ano);
    }
}