package eu.kudljo.emloyees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class BigData {

    record Person(String firstName, String lastName, long salary, String state) {
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

            Map<String, List<Person>> result = Files.lines(Path.of("PATH_OF_FILE")).parallel()
                    .skip(1)
                    .limit(10)
                    .map(line -> line.split(","))
                    .map(array -> new Person(array[2], array[4], Long.parseLong(array[25]), array[32]))
                    .collect(groupingBy(Person::state, TreeMap::new, toList()));

            long endTime = System.currentTimeMillis();

//            System.out.printf("$%,d.00%n", result);
            System.out.println(result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
