package com.clientRelationship.clientRelationshipProject.services;

import com.clientRelationship.clientRelationshipProject.models.AddUriModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterToApiGatewayService implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:4000/uris/add";
        try {
            HttpHeaders headers = new HttpHeaders();

            AddUriModel model = new AddUriModel("client-relationship", "http://client-relationship-service-brilhador" );
            ResponseEntity<String> res = this.restTemplate.postForEntity(url, model, String.class, headers);

            System.out.println("Response: " + res.getBody());
        } catch (RestClientResponseException ex) {
     
        } catch (RestClientException ex) {
        }
    }

    @Autowired()
    private RestTemplate restTemplate;

}
