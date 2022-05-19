package edu.up.br.projeto_dev_software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ProjetoDevSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDevSoftwareApplication.class, args);
	}
	@RequestMapping("")
	public String Home()
	{
	return "http://localhost:8080/ -> Online";
	}
}
