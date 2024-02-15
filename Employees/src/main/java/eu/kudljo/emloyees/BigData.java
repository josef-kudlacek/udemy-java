package eu.kudljo.emloyees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public class BigData {

    record Person(String firstName, String lastName, long salary, String state) {
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

//            Map<String, String> result =

            Files.lines(Path.of("C:\\Users\\Pepa Kudláček\\IdeaProjects\\Files\\Hr5m.csv")).parallel()
                    .skip(1)
//                    .limit(10)
                    .map(line -> line.split(","))
                    .map(array -> new Person(array[2], array[4], Long.parseLong(array[25]), array[32]))
                    .collect(groupingBy(Person::state, TreeMap::new,
                            collectingAndThen(summingLong(Person::salary), NumberFormat.getCurrencyInstance(Locale.US)::format)))
                    .forEach((state, salary) -> System.out.printf("%s \t %s%n", state, salary));

            long endTime = System.currentTimeMillis();

//            System.out.printf("$%,d.00%n", result);
//            System.out.println(result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
