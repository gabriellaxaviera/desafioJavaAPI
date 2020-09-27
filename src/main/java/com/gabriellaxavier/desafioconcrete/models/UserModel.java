package com.gabriellaxavier.desafioconcrete.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String passwd;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID token;

    @ManyToOne
    private List<PhoneModel> phone = new ArrayList<>();
//    private Data created;
//    private Data modified;
//    private Timestamp lastLogin;

    public UserModel(){
    }

    public UserModel(UUID id, String name, String email, String passwd, UUID token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.token = token;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public List<PhoneModel> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneModel> phone) {
        this.phone = phone;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(passwd, userModel.passwd) &&
                Objects.equals(token, userModel.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, passwd, token);
    }
}
