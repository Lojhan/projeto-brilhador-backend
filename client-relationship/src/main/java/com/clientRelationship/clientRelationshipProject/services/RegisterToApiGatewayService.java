package com.clientRelationship.clientRelationshipProject.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterToApiGatewayService {
    String gatewayUrl = "http://brilhador-api-gateway/uris";
    String appKey = "client-relationship";
    String appUrl = "http://client-relationship-service-brilhador";

    private RestTemplate restTemplate;

    public RegisterToApiGatewayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        register();
    }

    public void register() {
        String url = gatewayUrl + "/add";
        System.out.println("Registering to gateway: " + url);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("key", appKey);
            map.add("value", appUrl);
            HttpEntity<Map<String, Object>> entity = new HttpEntity(map, headers);

            ResponseEntity<String> res = this.restTemplate.postForEntity(url, entity, String.class, headers);

            System.out.println("Registered sucefully! Service Available at: " + res.getBody());
        } catch (RestClientResponseException ex) {
            ex.printStackTrace();
        } catch (RestClientException ex) {
            ex.printStackTrace();
        }
    }

    @Scheduled(cron = "0/10 0/1 * * * *")
    public void verifyOwnExistence() {
        // existan
        try {
            ResponseEntity<HashMap> res = this.restTemplate.getForEntity(gatewayUrl, HashMap.class);
            Boolean containsAppKey = ((Map<String, String>) res.getBody()).containsKey(appKey);
            if (!containsAppKey) register();
        } catch (RestClientResponseException ex) {
            ex.printStackTrace();
        } catch (RestClientException ex) {
            ex.printStackTrace();
        }
    }
}
