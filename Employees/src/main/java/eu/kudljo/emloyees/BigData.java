package eu.kudljo.emloyees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.stream.Collectors.summingLong;

public class BigData {

    record Person(String firstName, String lastName, long salary, String state) {
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

            Long result = Files.lines(Path.of("PATH_OF_FILE")).parallel()
                    .skip(1)
//                    .limit(10)
                    .map(line -> line.split(","))
                    .map(array -> new Person(array[2], array[4], Long.parseLong(array[25]), array[32]))
                    .collect(summingLong(Person::salary));

            long endTime = System.currentTimeMillis();

            System.out.printf("$%,d.00%n", result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
