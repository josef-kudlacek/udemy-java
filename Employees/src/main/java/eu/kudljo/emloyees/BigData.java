package eu.kudljo.emloyees;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import static eu.kudljo.constants.FilePath.PATH_OF_EMPLOYEES_FILE;
import static java.util.stream.Collectors.*;

public class BigData {

    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender) {
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

//            Map<String, String> result =

            TreeMap<String, Map<Character, String>> result = Files.lines(Path.of(PATH_OF_EMPLOYEES_FILE)).parallel()
                    .skip(1)
//                    .limit(10)
                    .map(line -> line.split(","))
                    .map(array -> new Person(array[2], array[4], new BigDecimal(array[25]), array[32], array[5].strip().charAt(0)))
                    .collect(
                            groupingBy(Person::state, TreeMap::new,
                                    groupingBy(Person::gender,
                                            collectingAndThen(
                                                    reducing(BigDecimal.ZERO, Person::salary, (a, b) -> a.add(b)),
                                                    NumberFormat.getCurrencyInstance(Locale.US)::format))
                            ));
//                    .forEach((state, salary) -> System.out.printf("%s \t %c \t %s%n", state, salary));

            long endTime = System.currentTimeMillis();

//            System.out.printf("$%,d.00%n", result);
            System.out.println(result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
