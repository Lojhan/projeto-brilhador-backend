package com.clientRelationship.clientRelationshipProject;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ClientRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRelationshipApplication.class, args);
	}

}
