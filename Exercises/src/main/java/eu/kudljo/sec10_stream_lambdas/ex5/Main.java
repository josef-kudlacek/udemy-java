package eu.kudljo.sec10_stream_lambdas.ex5;

import eu.kudljo.sec9_collections.ex1.Car;

import java.time.LocalDate;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        Stream<Car> cars = Stream.of(
                new Car("Tesla", "X", LocalDate.of(2015, 1, 1)),
                new Car("Tesla", "Y", LocalDate.of(2016, 1, 1)),
                new Car("Tesla", "Z", LocalDate.of(2017, 1, 1)),
                new Car("Tesla", "4", LocalDate.of(2020, 1, 1)),
                new Car("Tesla", "5", LocalDate.of(2022, 1, 1))
        );

        cars
                .sorted(comparing(Car::getMake)
                        .thenComparing(Car::getModel)
                        .thenComparingInt(Car::getYear)
                        .reversed()
                )
                .forEach(System.out::println);
    }
}
