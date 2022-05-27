package com.brilhador.authentication;

import com.brilhador.authentication.services.RegisterToApiGatewayService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableRabbit
@SpringBootApplication
@EnableScheduling
@RestController
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Autowired
	RegisterToApiGatewayService registerToApiGatewayService;

	@GetMapping("/health-check")
	public String home() {
		return "Hello World!";
	}

}
