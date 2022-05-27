package edu.up.br.projeto_dev_software;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.up.br.projeto_dev_software.services.RegisterToApiGatewayService;


@RestController
@SpringBootApplication
public class ProjetoDevSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDevSoftwareApplication.class, args);
	}
	@Autowired
	RegisterToApiGatewayService registerToApiGatewayService; 
	
	@RequestMapping("/health-check")
	public String Home()
	{
	return "http://localhost:8080/ -> Online";
	}
}
