package br.edu.up.operacaocontabil.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.up.operacaocontabil.domain.OperacaoContabil;

@Configuration
public class CargaInicial {
    private static final Logger log = LoggerFactory.getLogger(CargaInicial.class);

    @Bean CommandLineRunner
    iniciarDb(OperacaoContabilRepository repository){

        return args -> {
            log.info("Carregando..." + repository.save(new OperacaoContabil("OperacaoContabilDesc", "12345", 2)));
            log.info("Carregando..." + repository.save(new OperacaoContabil("OperacaoContabilDesc", "31241", 7)));
        };
    
}
}
