package edu.up.br.projeto_dev_software.domain.domain_security.dto;
import edu.up.br.projeto_dev_software.domain.domain_security.base.Role;

import java.io.Serializable;
import java.util.UUID;

public class UserResponse implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Role role;

    public UserResponse() {
        super();
    }

    public UserResponse(UUID id, String name, String email, String cpf, String phone, Role role) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
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
    public String toJSON() {
        // creates a json string from the object data
        String json = "{";
        json += "\"id\":\"" + id + "\",";
        json += "\"name\":\"" + name + "\",";
        json += "\"email\":\"" + email + "\",";
        json += "\"cpf\":\"" + cpf + "\",";
        json += "\"phone\":\"" + phone + "\",";
        json += "\"role\":\"" + role + "\"";
        json += "}";
        return json;
    }
}
