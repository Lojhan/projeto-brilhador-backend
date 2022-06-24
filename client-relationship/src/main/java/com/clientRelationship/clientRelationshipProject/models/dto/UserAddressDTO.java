package com.clientRelationship.clientRelationshipProject.models.dto;

public class UserAddressDTO extends UserResponse {
    private AddressViaCepDTO address;

    public UserAddressDTO() {
    }

    public UserAddressDTO(AddressViaCepDTO address) {
        this.address = address;
    }

    public AddressViaCepDTO getViaCepAddress() {
        return address;
    }

    public void setAddress(AddressViaCepDTO address) {
        this.address = address;
    }
}
