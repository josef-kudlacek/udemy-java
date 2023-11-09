package eu.kudljo.sec9_collections.ex3;

import eu.kudljo.sec9_collections.ex1.Car;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Car> cars = new HashMap<>();
        cars.put("Bob", new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.put("George", new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.put("Fred", new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.put("Jenny", new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.put("Leonidas", new Car("Tesla", "Z", LocalDate.of(2017, 1, 1)));
        cars.put("Carl", new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));
        cars.put("Joe", new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));
        cars.put("Hillary", new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));
        cars.put("Sarah", new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));

        for (Map.Entry<String, Car> car : cars.entrySet()) {
            System.out.printf("%s, %s%n", car.getKey(), car.getValue());
        }
    }
}
