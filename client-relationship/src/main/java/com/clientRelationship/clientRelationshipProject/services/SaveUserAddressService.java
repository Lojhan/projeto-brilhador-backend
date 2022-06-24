package com.clientRelationship.clientRelationshipProject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientRelationship.clientRelationshipProject.models.base.Address;
import com.clientRelationship.clientRelationshipProject.models.base.User;
import com.clientRelationship.clientRelationshipProject.models.dto.UserAddressDTO;
import com.clientRelationship.clientRelationshipProject.repositories.AddressRepository;
import com.clientRelationship.clientRelationshipProject.repositories.UserRepository;

@Service
public class SaveUserAddressService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public UserAddressDTO save(UserAddressDTO userAddressDTO) {
        User user = userRepository.findByEmail(userAddressDTO.getEmail()).get();
        Optional<Address> userAddressaddress = addressRepository.findByUserId(user.getId());
        Address address;
        if (userAddressaddress.isPresent()) {
            address = userAddressaddress.get();
            Address payload = userAddressDTO.getViaCepAddress().toAddress();
            address.setZipCode(payload.getZipCode());
            address.setStreet(payload.getStreet());
            address.setNumber(payload.getNumber());
            address.setComplement(payload.getComplement());
            address.setCity(payload.getCity());
            address.setState(payload.getState());
        } else {
            address = userAddressDTO.getViaCepAddress().toAddress();
            address.setUserId(user.getId());
        }
        
        addressRepository.save(address);
        return userAddressDTO;
    }
}
