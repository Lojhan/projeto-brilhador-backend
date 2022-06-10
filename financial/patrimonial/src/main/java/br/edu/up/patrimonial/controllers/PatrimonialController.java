package br.edu.up.patrimonial.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.up.patrimonial.domain.Patrimonial;
import br.edu.up.patrimonial.domain.Product;
import br.edu.up.patrimonial.repository.PatrimonialRepository;

@RestController
public class PatrimonialController {

    private final PatrimonialRepository repository;

    PatrimonialController(PatrimonialRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/patrimonial")
    Iterable<Patrimonial> listar() {
        return repository.findAll();
    }

    @GetMapping("/patrimonial/{id}")
    Patrimonial buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/patrimonial")
    Patrimonial incluir(@RequestBody Patrimonial novoPatrimonial) {
        return repository.save(novoPatrimonial);
    }

    @PutMapping("/patrimonial/{id}")
    Patrimonial atualizar(@RequestBody Patrimonial patrimonialAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(pat -> {
                    pat.setNome(patrimonialAlterado.getNome());
                    pat.setValor(patrimonialAlterado.getValor());
                    pat.setDataEntrada(patrimonialAlterado.getDataEntrada());
                    pat.setDataSaida(patrimonialAlterado.getDataSaida());
                    pat.setCreditoPis(patrimonialAlterado.getCreditoPis());
                    pat.setCreditoCofins(patrimonialAlterado.getCreditoCofins());
                    return repository.save(pat);
                })
                .orElseGet(() -> {
                    patrimonialAlterado.setId(id);
                    return repository.save(patrimonialAlterado);
                });
    }

    @DeleteMapping("/patrimonial/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/patrimonial/gerarBens")
    Iterable<Patrimonial> gerarPatrimonial() {

        RestTemplate restTemplate;

        restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "http://inventory-brilhador/product",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        List<Product> products = responseEntity.getBody();

        for (Product product : products) {

            String dataMovimento = formatter.format(product.getDateTime());
            String dataLanc = formatter.format(datinha);
            if (dataMovimento.equals(dataLanc)) {
                LancamentoCabecalho cabAux = new LancamentoCabecalho(datinha, "ES",
                        dataMovimento + "- Data DAtinha " + dataLanc + " Lançamento Referente ao Produto"
                                + product.getName() + "de id " + (String.valueOf(product.getId())));
                cabRepository.save(cabAux);
                lancRepository.save(new Lancamento(cabAux, 250, "Conta de Estoque", 0, product.getTotalPrice()));
                lancRepository.save(new Lancamento(cabAux, 200, "Conta de Resultado", product.getTotalPrice(), 0));
            }
        }
        return repository.findAll();
    }

}
