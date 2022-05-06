package br.edu.up.planocontas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PlanoContasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanoContasApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "http://localhost:8080/";
	}

}
