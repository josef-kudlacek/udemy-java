package eu.kudljo.sec9_collections.ex5;

import eu.kudljo.sec9_collections.ex1.Car;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Car> cars = new TreeSet<>();
        cars.add(new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.add(new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.add(new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.add(new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.add(new Car("Tesla", "Z", LocalDate.of(2017, 1, 1)));
        cars.add(new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));
        cars.add(new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));
        cars.add(new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));
        cars.add(new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
