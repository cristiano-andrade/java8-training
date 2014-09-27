package io.cristiano.java8.training.basics.domain;

import java.io.Serializable;

public class Plate implements Serializable {

    private String number;
    private String city;
    private String state;
    private boolean reflective;

    public Plate(String number, String city, String state) {
        this(number,city,state,false);
    }

    private Plate(String number, String city, String state, boolean reflective) {
        this.number = number;
        this.city = city;
        this.state = state;
        this.reflective = reflective;
    }

    public void setAsReflective(){
        this.reflective = true;
    }

    public boolean isReflective() {
        return reflective;
    }
}
