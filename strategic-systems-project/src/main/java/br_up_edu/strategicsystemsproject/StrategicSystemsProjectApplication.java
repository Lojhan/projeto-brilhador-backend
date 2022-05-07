package br_up_edu.strategicsystemsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StrategicSystemsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrategicSystemsProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "http://localhost:8080/";
	}

}
