package br.edu.up.pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages={"br.edu.up.pessoa","br.edu.up.vendedor", "br.edu.up.produto", "br.edu.up.venda"})
@ComponentScan({"br.edu.up.pessoa", "br.edu.up.vendedor", "br.edu.up.produto", "br.edu.up.venda"})
@EntityScan({"br.edu.up.pessoa","br.edu.up.vendedor", "br.edu.up.produto", "br.edu.up.venda"})
@EnableJpaRepositories({"br.edu.up.pessoa","br.edu.up.vendedor", "br.edu.up.produto", "br.edu.up.venda"})
public class PessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "http://localhost:8080/";
	}
}
