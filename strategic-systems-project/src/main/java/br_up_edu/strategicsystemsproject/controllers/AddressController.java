package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br_up_edu.strategicsystemsproject.domain.Address;
import br_up_edu.strategicsystemsproject.services.ViaCepService;

@RestController @RequestMapping("/address")
public class AddressController {
    
    @Autowired
    ViaCepService viaCepService;
    @GetMapping("/get-address-by-zip-code")
    public ResponseEntity<Address> getAddressByZipCode(
    @RequestParam("zipCode") String zipCode
    ) {
        try {
            Address address =  viaCepService.getAddressByZipCode(zipCode);
            return ResponseEntity.ok(address);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
