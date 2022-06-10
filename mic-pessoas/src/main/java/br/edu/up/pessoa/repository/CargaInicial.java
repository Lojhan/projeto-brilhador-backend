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
            log.info("Carregando..." + repository.save(new Pessoa("Pedro")));
            log.info("Carregando..." + repository.save(new Pessoa("Ana")));
        };
    }
    
}
