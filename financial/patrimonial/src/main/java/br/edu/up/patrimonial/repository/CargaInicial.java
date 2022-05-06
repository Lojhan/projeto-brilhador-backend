package br.edu.up.patrimonial.repository;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.up.patrimonial.domain.Patrimonial;

@Configuration
public class CargaInicial {
    private static final Logger log = LoggerFactory.getLogger(CargaInicial.class);

    @Bean CommandLineRunner
    iniciarDb(PatrimonialRepository repository){

        String str = "2022-07-10";
        Date dataEntrada = Date.valueOf(str);
        Date dataSaida = Date.valueOf(str);
        return args -> {
            log.info("Carregando..." + repository.save(new Patrimonial("Patrimonio", 1.5, 1.7, 1.8, dataEntrada)));
            log.info("Carregando..." + repository.save(new Patrimonial("Patrimonio", 1.6, 1.0, 1.1, dataEntrada, dataSaida)));
        };
    }
}