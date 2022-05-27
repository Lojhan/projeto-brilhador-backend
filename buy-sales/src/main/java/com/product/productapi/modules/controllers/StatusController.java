package com.product.productapi.modules.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class StatusController {

    @GetMapping("status")
    public ResponseEntity<HashMap<String, Object>> getApiStatus() {
        var response = new HashMap<String, Object>();

        response.put("service", "product-api");
        response.put("status", "up");
        response.put("HttpStatus", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

}
