package com.supplyChain.supplyChainProject;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplyChain.supplyChainProject.configuration.messaging.QueueConsumer;

@RestController
@SpringBootApplication
@EnableRabbit
public class SupplyChainProjectApplication {

	@Autowired
	QueueConsumer queueConsumer;

	public static void main(String[] args) {
		SpringApplication.run(SupplyChainProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "It is working";
	}

	@RequestMapping("/health-check")
	public String healthCheck(){
		return "It is working";
	}

}
