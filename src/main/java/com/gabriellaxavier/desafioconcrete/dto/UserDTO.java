package com.gabriellaxavier.desafioconcrete.dto;

import com.gabriellaxavier.desafioconcrete.models.UserModel;

import java.io.Serializable;
import java.util.UUID;

public class UserDTO implements Serializable {

    private UUID id;
    private UUID token;

    public UserDTO() {
    }

    public UserDTO(UUID id, UUID token) {
        this.id = id;
        this.token = token;
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

    public UserDTO(UserModel obj){
        id = obj.getId();
        token = obj.getToken();
    }
}
