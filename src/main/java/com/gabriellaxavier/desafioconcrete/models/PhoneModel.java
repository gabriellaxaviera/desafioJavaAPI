package com.gabriellaxavier.desafioconcrete.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PhoneModel {
    private String ddd;
    private String numberPhone;

    public PhoneModel(String ddd, String numberPhone) {
        this.numberPhone = numberPhone;
        this.ddd = ddd;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
