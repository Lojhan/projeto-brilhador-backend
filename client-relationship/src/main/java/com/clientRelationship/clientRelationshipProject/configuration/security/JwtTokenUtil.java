package com.clientRelationship.clientRelationshipProject.configuration.security;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.models.dto.ValidationResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class JwtTokenUtil {

    private final RestTemplate restTemplate;

    public JwtTokenUtil(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ValidationResponse validateToken(String token) {
        try {
            String url = "http://authentication-service-brilhador/validate-token";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("token", token);
            HttpEntity<Map<String, Object>> entity = new HttpEntity(map, headers);

            // send POST request
            ResponseEntity<ValidationResponse> response = this.restTemplate.postForEntity(url, entity, ValidationResponse.class);
            return response.getBody();
        } catch (Exception ex) {
            return new ValidationResponse(false, null);
        }
    }

    public UserDetails getUserDetails(UserResponse user) {
        return new UserDetails() {
            @Override
            public String getUsername() {
                return user.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public String getPassword() {
                return "";
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
                return grantedAuthorities;
            }
        };
    };
}
