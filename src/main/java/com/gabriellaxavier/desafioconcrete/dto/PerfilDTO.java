package com.gabriellaxavier.desafioconcrete.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriellaxavier.desafioconcrete.models.UserModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class PerfilDTO implements Serializable {

    private UUID token;
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime last_login;

    public PerfilDTO() {
    }

    public PerfilDTO(UUID token, UUID id, LocalDateTime last_login) {
        this.token = token;
        this.id = id;
        this.last_login = last_login;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public PerfilDTO(UserModel obj){
        id = obj.getId();
        token = obj.getToken();
        last_login = obj.getLast_login();
    }
}
