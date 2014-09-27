package io.cristiano.java8.training.basics.domain;

import java.io.Serializable;

public class Plate implements Serializable {

    private String number;
    private String city;
    private String state;

    public Plate(String number, String city, String state) {
        this.number = number;
        this.city = city;
        this.state = state;
    }
}
