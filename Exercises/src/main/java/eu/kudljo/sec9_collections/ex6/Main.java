package eu.kudljo.sec9_collections.ex6;

import eu.kudljo.sec9_collections.ex1.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class Main {
    public static void main(String[] args) {
        List<Car> cars0 = prepareCars();

        System.out.println("#### Sorting ####");
        cars0.sort(naturalOrder());
        for (Car car : cars0) {
            System.out.println(car);
        }

        if (args.length == 1) {
            String carModel = args[0];
            for (Iterator<Car> iterator = cars0.iterator(); iterator.hasNext(); ) {
                Car iteratedCard = iterator.next();
                if (iteratedCard.getModel().equals(carModel)) iterator.remove();
            }

            System.out.printf("#### Cars after removed car: %s ####%n", carModel);
            cars0.sort(naturalOrder());
            for (Car car : cars0) {
                System.out.println(car);
            }
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
