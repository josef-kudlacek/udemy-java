package eu.kudljo.sec9_collections.ex2;

import eu.kudljo.sec9_collections.ex1.Car;

import java.time.LocalDate;
import java.util.*;

public class Main {

    // No duplicates
    public static void main(String[] args) {
        List<Car> cars0 = prepareCars();

        System.out.println("#### Sorting via implementing comparable and no duplicates ####");
        Set<Car> cars = new HashSet<>(cars0);
        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println("#### Sorting via Collections ####");
        cars0.sort(Comparator.naturalOrder());
        for (Car car : cars0) {
            System.out.println(car);
        }

        System.out.println("#### Reverse sorting via Collections ####");
        Collections.reverse(cars0);
        for (Car car : cars0) {
            System.out.println(car);
        }
    }

    private static List<Car> prepareCars() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.add(new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));
        cars.add(new Car("Tesla", "Z", LocalDate.of(2017, 1, 1)));
        cars.add(new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));
        cars.add(new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.add(new Car("Tesla", "5", LocalDate.of(2022, 1, 1)));
        cars.add(new Car("Tesla", "X", LocalDate.of(2015, 1, 1)));
        cars.add(new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)));
        cars.add(new Car("Tesla", "4", LocalDate.of(2020, 1, 1)));

        return cars;
    }
}
