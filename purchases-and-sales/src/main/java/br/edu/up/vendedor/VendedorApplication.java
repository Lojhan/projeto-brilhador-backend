package br.edu.up.vendedor;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ConditionalOnProperty(name = "my.other.active", havingValue = "true", matchIfMissing = false)
public class VendedorApplication {
    @RequestMapping("/")
	public String home(){
		return "http://localhost:8080/";
	}    
}
