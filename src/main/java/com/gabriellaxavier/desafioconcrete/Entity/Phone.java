package com.gabriellaxavier.desafioconcrete.Entity;

import java.io.Serializable;

public class Phone {
    private String ddd;
    private String numberPhone;

    public Phone(String ddd, String numberPhone) {
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
