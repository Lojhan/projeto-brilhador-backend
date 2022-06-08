package br.up.projeto.repository;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.LancamentoValor;

import org.slf4j.Logger;

@Configuration
public class CargaInicialLancamentoValor {

    private static final Logger log = LoggerFactory.getLogger(LancamentoValor.class);

    @Bean CommandLineRunner
    iniciarDbLancamentoValor(LancamentoValorRepository repository){
        return args -> {
            log.info("Carregamento..." + repository.save(new LancamentoValor("2022-04-03", 15.50, 1, 1, 2)));
        };
    }
}
