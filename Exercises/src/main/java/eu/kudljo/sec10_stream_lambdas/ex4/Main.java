package eu.kudljo.sec10_stream_lambdas.ex4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        List<CarExtended> cars = new ArrayList<>();
        cars.add(new CarExtended("Tesla", "X", LocalDate.of(2015, 1, 1), 120000));
        cars.add(new CarExtended("Tesla", "Y", LocalDate.of(2016, 1, 1), 200000));
        cars.add(new CarExtended("Tesla", "Z", LocalDate.of(2017, 1, 1), 250000));
        cars.add(new CarExtended("Tesla", "4", LocalDate.of(2020, 1, 1), 275000));
        cars.add(new CarExtended("Tesla", "5", LocalDate.of(2022, 1, 1), 320000));

        IntSummaryStatistics summaryStatistics = cars.stream()
                .mapToInt(car -> car.getPrice())
                .summaryStatistics();

        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Sum of prices: %s%n", moneyFormatter.format(summaryStatistics.getSum()));
        System.out.printf("Average of prices: %s", moneyFormatter.format(summaryStatistics.getAverage()));
    }
}
