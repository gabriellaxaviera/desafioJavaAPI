package com.gabriellaxavier.desafioconcrete.dto;

import com.gabriellaxavier.desafioconcrete.models.UserModel;

import java.io.Serializable;
import java.util.UUID;

public class LoginDTO implements Serializable {

    private UUID id;
    private UUID token;
    private String email;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(UUID id, UUID token, String email, String password) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDTO(UserModel obj){
        id = obj.getId();
        token = obj.getToken();
        email = obj.getEmail();
        password = obj.getPassword();
    }
}
