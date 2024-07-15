package eu.kudljo.sec10_stream_lambdas.ex7;

import eu.kudljo.sec10_stream_lambdas.ex6.CarExtended;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        Supplier<Stream<CarExtended>> carsSupplier =
                () -> Stream.of(
                        new CarExtended("Tesla", "S", LocalDate.of(2014, 1, 1), BigDecimal.valueOf(90000.99)),
                        new CarExtended("Tesla", "X", LocalDate.of(2015, 1, 1), BigDecimal.valueOf(110000.99)),
                        new CarExtended("Tesla", "3", LocalDate.of(2016, 1, 1), BigDecimal.valueOf(55000.99)),
                        new CarExtended("Tesla", "Y", LocalDate.of(2017, 1, 1), BigDecimal.valueOf(60000.99)),
                        new CarExtended("Tesla", "Roadster", LocalDate.of(2009, 1, 1), BigDecimal.valueOf(135000.99)),
                        new CarExtended("Lucid", "Air", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(77399.99)),
                        new CarExtended("Hyundai", "Ioniq", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(34250.00)),
                        new CarExtended("Hyundai", "Kona", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(38575.00)),
                        new CarExtended("Porsche", "Taycan", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(81250.00)),
                        new CarExtended("Audi", "e-tron", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(66995.00)),
                        new CarExtended("Volkswagen", "ID.4", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(41190.00))
                );

        System.out.println("1. Determine total price by make:");
        carsSupplier.get()
                .collect(groupingBy(CarExtended::getMake, TreeMap::new,
                        collectingAndThen(summingDouble(car -> car.getPrice().doubleValue()), NumberFormat.getCurrencyInstance(Locale.US)::format)))
                .forEach((make, price) -> System.out.printf("%s \t %s%n", make, price));

        System.out.println("2. Determine average car price by make:");
        carsSupplier.get()
                .collect(groupingBy(CarExtended::getMake, TreeMap::new,
                        collectingAndThen(averagingDouble(car -> car.getPrice().doubleValue()), NumberFormat.getCurrencyInstance(Locale.US)::format)))
                .forEach((make, price) -> System.out.printf("%s \t %s%n", make, price));

        System.out.println("3. Determine number of cars by year and then by make:");
        Map<Integer, Map<String, Long>> countByYearAndMake = carsSupplier.get()
                .collect(
                        groupingBy(CarExtended::getYear, TreeMap::new,
                                groupingBy(CarExtended::getMake,
                                        Collectors.counting())
                        ));
        System.out.println(countByYearAndMake);

        System.out.print(
                """
                4. Determine number of cars by make by first creating a new, empty Map, then iterating
                over the collection of cars (you’ve been using for previous exercises) and using a
                functional method of the Map interface to populate your empty Map.
                """);

        Map<String, Integer> countsByMake = new HashMap<>();
        carsSupplier.get()
                .forEach(car -> countsByMake.merge(car.getMake(), 1, Integer::sum));
        System.out.println(countsByMake);
    }
}
