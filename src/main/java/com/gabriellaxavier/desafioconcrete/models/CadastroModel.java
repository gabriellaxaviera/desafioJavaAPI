package com.gabriellaxavier.desafioconcrete.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class CadastroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String email;
    private String passwd;
    private List<PhoneModel> phone;
//    private Long token;
//    private Data created;
//    private Data modified;
//    private Timestamp lastLogin;

    public CadastroModel(){
    }

    public CadastroModel(String id, String name, String email, String passwd, List<PhoneModel> phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.phone = phone;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
