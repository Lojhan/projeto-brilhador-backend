package com.apigateway.gateway.controllers;

import java.util.HashMap;
import java.util.Map;

import com.apigateway.gateway.configuration.UriConfiguration;
import com.apigateway.gateway.models.AddUriModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "/uris")
public class UriController {
    
    @Autowired
    UriConfiguration uriConfiguration;

    @GetMapping("")
    public Map<String, String> getUris() {
        HashMap<String, String> uris =  new HashMap<String, String>(uriConfiguration.getUris());

        uris.forEach((k,v) -> uris.replace(k, String.format("http://localhost:4000/%s/**", k)));
        return uris;
    }

    @PostMapping("/add") 
    public String addUri(AddUriModel model) {
        uriConfiguration.addUri(model.getKey(), model.getValue());
        return String.format("http://localhost:4000/%s/**", model.getKey());
    }
}
