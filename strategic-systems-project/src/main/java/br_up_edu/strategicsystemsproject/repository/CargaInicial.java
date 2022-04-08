// package br_up_edu.strategicsystemsproject.repository;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import br_up_edu.strategicsystemsproject.domain.Area;

// @Configuration
// public class CargaInicial {

//     private static final Logger log = LoggerFactory.getLogger(CargaInicial.class);

//     @Bean CommandLineRunner
//     iniciarDb(AreaRepository repository){
//         return args -> {
//             log.info("Carregando..." + repository.save(new Area("RH", "Recrutar Pessoas")));
//             log.info("Carregando..." + repository.save(new Area("Produto", "Gestão de projetos")));
//         };
//     }
    
// }