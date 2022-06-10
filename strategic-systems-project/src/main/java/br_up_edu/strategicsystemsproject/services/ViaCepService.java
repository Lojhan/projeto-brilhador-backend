package br_up_edu.strategicsystemsproject.services;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br_up_edu.strategicsystemsproject.domain.Address;

@Service
public class ViaCepService {
    
    private RestTemplate restTemplate;

    ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Address getAddressByZipCode(String zipCode) {
        Map<String, ?> obj = restTemplate.getForObject("https://viacep.com.br/ws/" + zipCode + "/json/", Map.class);
        obj.values().forEach(System.out::println);
        return new Address(
            obj.get("logradouro").toString(), 
            "", 
            obj.get("complemento").toString(), 
            obj.get("cep").toString(), 
            obj.get("localidade").toString(), 
            obj.get("uf").toString(), 
            "Brasil"
            );
    }
}
