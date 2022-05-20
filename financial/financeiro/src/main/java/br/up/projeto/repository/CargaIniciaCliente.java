package br.up.projeto.repository;

import br.up.projeto.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaIniciaCliente {

    private static final Logger log = LoggerFactory.getLogger(CargaIniciaCliente.class);

    @Bean CommandLineRunner 
    iniciarDbCliente(ClienteRepository repository) {
        return args -> {
            log.info("Carregando... " + repository.save(new Cliente("Pedro", "123.542.764-12", "1997-03-15", "pedro@email.com", "21o3421h4")));
            log.info("Carregando... " + repository.save(new Cliente("Ana", "542.954.764-27", "2001-08-29", "ana@email.com", "4h2oh413nl")));
        };
    }
}
