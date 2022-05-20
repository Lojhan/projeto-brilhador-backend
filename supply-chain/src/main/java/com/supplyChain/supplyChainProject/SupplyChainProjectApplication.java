package com.supplyChain.supplyChainProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SupplyChainProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyChainProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "It is working";
	}

}
