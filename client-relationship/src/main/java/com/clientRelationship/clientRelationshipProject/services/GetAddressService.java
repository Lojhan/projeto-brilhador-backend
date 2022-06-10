package com.clientRelationship.clientRelationshipProject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientRelationship.clientRelationshipProject.models.base.Address;

@Service
public class GetAddressService {
    
    private RestTemplate restTemplate;

    GetAddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Address getAddressByZipCode(String zipCode) {
        Address address = restTemplate.getForObject("http://strategic-systems-services-brilhador/address/get-address-by-zip-code?zipCode=" + zipCode, Address.class);
        return address;
    }
}
