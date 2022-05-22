package com.apigateway.gateway.services;

import java.util.HashMap;
import java.util.Map;

import com.apigateway.gateway.configuration.UriConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class HealthCheckService {

	@Autowired
	private UriConfiguration uriConfiguration;

    @Autowired()
    private RestTemplate restTemplate;
    
    @Scheduled(cron = "0/30 0/1 * * * *")
    public void run() throws Exception {
        Map<String, String> uris = new HashMap<String, String>(uriConfiguration.getUris());
        uris.forEach((k, v) -> doHealthCheck(k, v));
    }

	public void doHealthCheck(String key, String url) {
        
        System.out.println("\nChecking health of: " + key + " at: " + url + " ...");
        try {
            HttpHeaders headers = new HttpHeaders();
            this.restTemplate.getForEntity(url + "/health-check", null, headers);
            System.out.println("\t -> Service: " + key + " is UP!");
        } catch (RestClientResponseException ex) {
            int code = ex.getRawStatusCode();
            if (code != 404) uriConfiguration.removeUri(key);
            else {
                System.out.println("\t -> Service is running, but consider adding a /health-check endpoint to it's base controller.");
            }
        } catch (RestClientException ex) {
            System.out.println("\t -> Service is DOWN!");
            uriConfiguration.removeUri(key);
        }
    }
}
