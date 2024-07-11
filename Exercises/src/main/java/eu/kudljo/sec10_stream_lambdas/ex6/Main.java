package eu.kudljo.sec10_stream_lambdas.ex6;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<CarExtended> cars = Stream.of(
                new CarExtended("Tesla", "S", LocalDate.of(2014, 1, 1), BigDecimal.valueOf(90000.99)),
                new CarExtended("Tesla", "X", LocalDate.of(2015, 1, 1), BigDecimal.valueOf(110000.99)),
                new CarExtended("Tesla", "3", LocalDate.of(2016, 1, 1), BigDecimal.valueOf(55000.99)),
                new CarExtended("Tesla", "Y", LocalDate.of(2017, 1, 1), BigDecimal.valueOf(60000.99)),
                new CarExtended("Tesla", "Roadster", LocalDate.of(2009, 1, 1), BigDecimal.valueOf(135000.99))
        );

        Optional<String> outputText = cars
                .map(CarExtended::getModel)
                .reduce((a, b) -> a.concat(", ").concat(b));

        System.out.println(outputText.orElse("N/A"));
    }
}
