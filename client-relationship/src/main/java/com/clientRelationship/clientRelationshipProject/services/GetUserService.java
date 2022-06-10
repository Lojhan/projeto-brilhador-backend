package com.clientRelationship.clientRelationshipProject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;

@Service
public class GetUserService {
    
    RestTemplate restTemplate;

    GetUserService(
        RestTemplate restTemplate
    ){
        this.restTemplate = restTemplate;
    }

    public UserResponse getUser(String userId) {
        return restTemplate.getForObject(
            "http://authentication-service-brilhador/users/{userId}",
            UserResponse.class,
            userId
        );
    }
}
