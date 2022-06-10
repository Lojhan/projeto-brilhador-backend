package br.edu.up.pessoa.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import br.edu.up.pessoa.domain.Pessoa;


@Configuration
public class CargaInicial {

    private static final Logger log = LoggerFactory.getLogger(CargaInicial.class);

    @Bean CommandLineRunner
    iniciarDb(PessoaRepository repository){
        return args -> {
            log.info("Carregando..." + repository.save(new Pessoa("Thiago", "06/02/1997", "thiago@gmail.com", "09871204922", "25/02/2008", 5000.0, 0, 0, "ITAU","8629", "04511-6")));
            log.info("Carregando..." + repository.save(new Pessoa("Ana", "28/06/1997", "ana@gmail.com", "08997608911", "25/02/2022", 2500.0, 0, 0, "SANTANDER","1459", "15046-8")));
            
            
          
            
        };
    }
    
}
