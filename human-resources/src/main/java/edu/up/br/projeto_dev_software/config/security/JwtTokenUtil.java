package edu.up.br.projeto_dev_software.config.security;

import edu.up.br.projeto_dev_software.domain.domain_security.dto.UserResponse;
import edu.up.br.projeto_dev_software.domain.domain_security.dto.ValidationResponse;
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

import java.util.*;

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
