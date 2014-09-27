package io.cristiano.java8.training.basics.domain;

import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private String year;
    private String color;
    private Plate plate;


    public Car(String model, String year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public void addPlate(final Plate plate){
       this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Plate getPlate() {
        return plate;
    }
}
