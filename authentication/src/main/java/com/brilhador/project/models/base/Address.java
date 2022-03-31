package com.brilhador.project.models.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
    
    @Id
    @GeneratedValue
    private String id;

    private String street;
    private String number;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String id, String street, String number, String complement, String zipCode, String city,
            String state, String country) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
