package io.cristiano.java8.training.basics.domain;

@FunctionalInterface
public interface CarRegistration {
    Plate register(String number,String city, String model);
}
