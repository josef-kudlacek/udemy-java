package eu.kudljo.emloyees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigData {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

            Long result = Files.lines(Path.of("PATH_OF_FILE")).parallel()
                    .skip(1)
//                    .limit(10)
                    .map(line -> line.split(","))
                    .map(line -> line[25])
                    .mapToLong(salary -> Long.parseLong(salary))
                    .sum();
//                    .collect(Collectors.summingLong(salary -> Long.parseLong(salary)));

            long endTime = System.currentTimeMillis();

            System.out.printf("$%,d.00%n", result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
