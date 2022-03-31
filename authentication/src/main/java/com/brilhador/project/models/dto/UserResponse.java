package com.brilhador.project.models.dto;

import java.io.Serializable;
import java.util.UUID;

import com.brilhador.project.models.base.Address;
import com.brilhador.project.models.base.Role;

public class UserResponse implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Address address;
    private Role role;

    public UserResponse(UUID id, String name, String email, String cpf, String phone, Address address, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
