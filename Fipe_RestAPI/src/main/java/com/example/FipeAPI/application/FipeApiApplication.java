// Define o pacote ao qual esta classe pertence.
// O pacote ajuda a organizar as classes da aplicação.
package com.example.FipeAPI.application;

// Importa a classe SpringApplication do Spring Boot.
// Ela é responsável por iniciar a aplicação Spring.
import org.springframework.boot.SpringApplication;

// Importa a anotação @SpringBootApplication.
// Essa anotação configura automaticamente vários recursos necessários
// para uma aplicação Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Indica que esta classe é a classe principal de uma aplicação Spring Boot.
// A anotação @SpringBootApplication reúne, entre outras coisas:
// - @Configuration: permite definir configurações do Spring;
// - @EnableAutoConfiguration: ativa a configuração automática;
// - @ComponentScan: procura componentes/classes gerenciados pelo Spring.
@SpringBootApplication(scanBasePackages = {"com.example"})

// Declara a classe principal da aplicação.
// "public" significa que a classe pode ser acessada de outros pacotes.
// "class" indica que estamos criando uma classe.
// "FipeApiApplication" é o nome da classe.
public class FipeApiApplication {

	// Declara o método principal da aplicação Java.
	// "public": pode ser acessado pela JVM.
	// "static": pode ser executado sem criar um objeto da classe.
	// "void": o método não retorna nenhum valor.
	// "main": é o ponto de entrada da aplicação Java.
	// "String[] args": recebe argumentos passados na inicialização.
	public static void main(String[] args) {

		// Inicializa a aplicação Spring Boot.
		//
		// SpringApplication.run() cria o contexto do Spring,
		// realiza as configurações automáticas e inicia o servidor
		// da aplicação, caso seja uma aplicação web.
		//
		// FipeApiApplication.class informa ao Spring qual é a classe
		// principal que deve ser usada como referência para inicialização.
		//
		// args repassa para o Spring os argumentos recebidos pelo
		// método main.
		SpringApplication.run(FipeApiApplication.class, args);
	}
}