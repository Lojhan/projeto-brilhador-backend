package com.clientRelationship.clientRelationshipProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientRelationship.clientRelationshipProject.models.base.Address;
import com.clientRelationship.clientRelationshipProject.models.dto.SaveClientAddressDTO;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.services.SaveClientAddressService;

@RestController @RequestMapping("save-client-address")
public class SaveClientAddressController {
    
    @Autowired
    SaveClientAddressService service;
    
    @PostMapping("")
    public ResponseEntity<Address> saveClientAddress(
        SaveClientAddressDTO dto,
        @RequestAttribute("user") UserResponse user
    ) {
        try {
            Address address = service.saveClientAddress(dto.getZipCode(), user);
            return ResponseEntity.ok(address);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
