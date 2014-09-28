package io.cristiano.java8.basics.traning.basics.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.cristiano.java8.training.basics.domain.Car;
import io.cristiano.java8.training.basics.domain.CarRegistration;
import io.cristiano.java8.training.basics.domain.Plate;
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

    @Test
    public void should_filter_black_cars_using_function() {
        List<Car> expected = CarService.filter(cars, (Car c) -> "black".equals(c.getColor()));
        Assert.assertEquals(2, expected.size());
    }

    @Test
    public void should_register_a_car(){
        final Car car  = new Car("COROLLA","2012","white");

        CarRegistration carRegistration = (number,city,state) -> new Plate(number,city,state);
        CarService.register(car,carRegistration.register("AAA-9999","SAO PAULO","SP"));

        Assert.assertNotNull(car.getPlate());
    }

    @Test
    public void should_register_a_car_with_reflective_plate(){
        final Car car  = new Car("COROLLA","2012","white");

        CarRegistration carRegistration = (number,city,state) -> {
            Plate plate = new Plate(number,city,state);
            plate.setAsReflective();
            return plate;
        };

        CarService.register(car,carRegistration.register("AAA-9999","SAO PAULO","SP"));

        Assert.assertNotNull(car.getPlate());
        Assert.assertTrue(car.getPlate().isReflective());
    }

    @Test
    public void should_sort_cars_by_color(){
        Collections.sort(cars,(c1, c2) -> c1.getColor().compareTo(c2.getColor()));
        Assert.assertEquals("black",cars.get(0).getColor());
    }

    @Test
    public void should_sort_cars_by_color_using_method_reference(){
        Collections.sort(cars,Comparator.comparing(Car::getColor));
        Assert.assertEquals("black",cars.get(0).getColor());
    }

    @Test
    public void should_sort_cars_by_color_using_method_reference_pass_by_pass(){
        Function<Car,String> function = Car::getColor;
        Comparator<Car> comparator = (c1,c2) -> function.apply(c1).compareTo(function.apply(c2));
        Collections.sort(cars,comparator);
        Assert.assertEquals("black",cars.get(0).getColor());
    }

}
