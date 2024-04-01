package eu.kudljo.emloyees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static eu.kudljo.constants.FilePath.PATH_OF_EMPLOYEES_FILE;

public class StateCounter {
    public static void main(String[] args) throws IOException {
        Map<String, Long> stateCounts = new HashMap<>();
        Files.lines(Path.of(PATH_OF_EMPLOYEES_FILE))
                .skip(1)
                .map(line -> line.split(","))
//                .forEach(array -> stateCounts.compute(array[32], (k, v) -> v == null ? 1L : v + 1));
                .forEach(array -> stateCounts.merge(array[32], 1L, (x, y) -> x + y));
        System.out.println(stateCounts);

//        List.of("cat", "dog").replaceAll(String::toUpperCase);

        List<String> animals = new ArrayList(List.of("cat", "dog"));
        animals.removeIf(animal -> animal.startsWith("c"));
        animals.forEach(System.out::printf);

//        Long currentPopulation = stateCounts.get("CA");
//        if (currentPopulation == null) {
//            stateCounts.put("CA", 1L);
//        } else {
//            stateCounts.put("CA", ++currentPopulation);
//        }
    }
}
