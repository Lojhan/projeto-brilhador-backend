package com.clientRelationship.clientRelationshipProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientRelationship.clientRelationshipProject.models.base.Address;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.repositories.AddressRepository;

@Service
public class SaveClientAddressService {
    
    @Autowired private GetAddressService getAddressService;
    @Autowired private AddressRepository addressRepository;

    public Address saveClientAddress(String zipCode, UserResponse user) {
        Address address = getAddressService.getAddressByZipCode(zipCode);
        address.setUser(user.toUser());
        addressRepository.save(address);
        return address;
    }
}
