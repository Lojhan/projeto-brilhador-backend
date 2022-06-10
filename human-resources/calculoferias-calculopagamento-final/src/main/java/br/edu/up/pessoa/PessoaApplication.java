package br.edu.up.pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class PessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "http://localhost:8080/";
	}
}
