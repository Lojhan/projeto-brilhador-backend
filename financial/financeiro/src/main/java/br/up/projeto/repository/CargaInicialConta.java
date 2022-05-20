package br.up.projeto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.Conta;

@Configuration
public class CargaInicialConta {
    
    private static final Logger log = LoggerFactory.getLogger(CargaInicialConta.class);

    @Bean CommandLineRunner
    iniciarDbConta(ContaRepository repository){
        return args -> {
            log.info("Carregando..." + repository.save(new Conta("Conta Caixa", "Caixa", "756", 179)));
            log.info("Carregando..." + repository.save(new Conta("Conta Bradesco", "Bradesco", "0001", 258)));
        };

    }
}
