package com.clientRelationship.clientRelationshipProject;

import com.clientRelationship.clientRelationshipProject.services.RegisterToApiGatewayService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableRabbit
@SpringBootApplication
@RestController
@EnableScheduling
public class ClientRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRelationshipApplication.class, args);
	}

	@Autowired
	RegisterToApiGatewayService registerToApiGatewayService;

	@GetMapping("/health-check")
	public String healthCheck() {
		return "OK";
	}
}
