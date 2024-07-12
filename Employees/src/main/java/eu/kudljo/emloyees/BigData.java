package eu.kudljo.emloyees;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static eu.kudljo.constants.FilePath.PATH_OF_EMPLOYEES_FILE;

public class BigData {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.ENGLISH);

    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender,
                  LocalDate birthDate, LocalTime birthTime) {
        long getAge() {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }

        String getDOBAsText() {
            return dateFormatter.format(birthDate);
        }

        LocalDateTime getCompleteDOB() {
            return LocalDateTime.of(birthDate, birthTime);
        }
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

            Files.lines(Path.of(PATH_OF_EMPLOYEES_FILE)).parallel()
                    .skip(1)
                    .limit(20)
                    .map(line -> line.split(","))
                    .map(array -> new Person(array[2], array[4], new BigDecimal(array[25]), array[32],
                            array[5].strip().charAt(0),
                            LocalDate.parse(array[10], dateFormatter),
                            LocalTime.parse(array[11], timeFormatter)))
                    .filter(person -> person.getAge() < 30)
//                    .count();
                    .forEach(person -> System.out.printf("%s, %s %s - %d%n", person.lastName(), person.firstName(),
                            person.getDOBAsText(), person.getAge()));
            long endTime = System.currentTimeMillis();

//            System.out.printf("$%,d.00%n", result);
//            System.out.println(count);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
