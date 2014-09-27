package io.cristiano.java8.basics.traning.basics.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.cristiano.java8.training.basics.domain.Car;
import io.cristiano.java8.training.basics.service.CarService;

public class CarServiceTest {

    private final List<Car> cars = new ArrayList<>(5);

    @Before
    public void setUp() {
        Car yellowCar = new Car("ASTRA", "2012", "yellow");
        Car greenCar = new Car("ASTRA", "2012", "green");
        Car blackCar = new Car("FIESTA", "2010", "black");
        Car blackCar2 = new Car("COROLLA", "2014", "black");
        Car grayCar = new Car("CIVIC", "2014", "gray");

        cars.addAll(Arrays.asList(yellowCar, greenCar, blackCar, blackCar2, grayCar));
    }


    @Test
    public void should_filter_yellow_cars() {
        List<Car> expected = CarService.filter(cars, (Car c) -> "yellow".equals(c.getColor()));
        Assert.assertEquals(1, expected.size());
    }

    @Test
    public void should_filter_gray_cars() {
        List<Car> expected = CarService.filter(cars, (Car c) -> "gray".equals(c.getColor()));
        Assert.assertEquals(1, expected.size());
    }

    @Test
    public void should_filter_green_cars() {
        List<Car> expected = CarService.filter(cars, (Car c) -> "green".equals(c.getColor()));
        Assert.assertEquals(1, expected.size());
    }

    @Test
    public void should_filter_black_cars() {
        List<Car> expected = CarService.filter(cars, (Car c) -> "black".equals(c.getColor()));
        Assert.assertEquals(2, expected.size());
    }

}
