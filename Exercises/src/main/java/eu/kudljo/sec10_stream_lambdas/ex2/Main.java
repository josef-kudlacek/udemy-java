package eu.kudljo.sec10_stream_lambdas.ex2;

import eu.kudljo.sec9_collections.ex1.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.add(new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.add(new Car("Tesla", "Z", LocalDate.of(2017, 1, 1)));
        cars.add(new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));
        cars.add(new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));

        cars.stream()
                .filter(car -> car.getYear() < 2020)
                .forEach(System.out::println);
    }
}
