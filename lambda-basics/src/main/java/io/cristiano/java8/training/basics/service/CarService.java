package io.cristiano.java8.training.basics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.cristiano.java8.training.basics.domain.Car;
import io.cristiano.java8.training.basics.domain.CarRegistration;
import io.cristiano.java8.training.basics.domain.Plate;

public class CarService {

    /**
     * Return a <code>List</code> of cars those match a predicate
     *
     * @param cars      the cars
     * @param predicate
     * @return cars those match a predicate
     */
    public static List<Car> filter(List<Car> cars, Predicate<Car> predicate) {

        List<Car> result = new ArrayList<>();

        cars.forEach((car) -> {
            if (predicate.test(car)) {
                result.add(car);
            }
        });

        return result;
    }

    public static void register(Car car, Plate plate) {
        car.addPlate(plate);
    }


}
