package br.up.projeto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.MeioPagamento;

@Configuration
public class CargaIniciaMeioPagamento {

    private static final Logger log = LoggerFactory.getLogger(CargaIniciaMeioPagamento.class);

    @Bean CommandLineRunner 
    iniciarDbMeioPagamento(MeioPagamentoRepository repository) {
        return args -> {
            log.info("Carregando... " + repository.save(new MeioPagamento("Boleto","01")));
            log.info("Carregando... " + repository.save(new MeioPagamento("Pix","25")));
        };
    }
}
