package com.gabriellaxavier.desafioconcrete.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Login implements Serializable {
    private String id;
    private String name;
    private String email;
    private String passwd;
    private List<Phone> phone;

    public Login(){
    }

    public Login(String id, String name, String email, String passwd, List<Phone> phone) {
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

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(id, login.id) &&
                Objects.equals(passwd, login.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passwd);
    }
}
