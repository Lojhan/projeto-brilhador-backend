package br.edu.up.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	// TODO GERAL: conferir uso de long/Long em todas as entidades
	// TODO GERAL: disponibilizar endpoints
	// TODO GERAL: testar todos os endpoints via Postman
}
