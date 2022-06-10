package br.edu.up.vendedor.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.edu.up.vendedor.domain.Vendedor;

@Component
public class CargaInicial2 {

    private static final Logger log = LoggerFactory.getLogger(CargaInicial2.class);
  

    @Bean CommandLineRunner
    iniciarDbVendas(VendedorRepository repository){
        return args -> {
            log.info("Carregando..." + repository.save(new Vendedor("Marcelo", 4.5)));
            log.info("Carregando..." + repository.save(new Vendedor("Luana", 6.7)));          
        };
    }
    
}
