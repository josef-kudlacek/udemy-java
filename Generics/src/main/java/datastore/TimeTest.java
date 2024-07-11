package datastore;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TimeTest {
    public static void main(String[] args) {
        System.out.println(Instant.now());
    }

    private static void localDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now.plus(3, ChronoUnit.YEARS));

        LocalDate newYear = LocalDate.of(2020, 1, 1);
        System.out.println(newYear.getDayOfWeek());

        newYear.datesUntil(LocalDate.now(), Period.ofMonths(6))
                .forEach(System.out::println);

        List<LocalDate> leapYears = LocalDate.now().datesUntil(LocalDate.now().plusYears(10), Period.ofYears(1))
                .filter(LocalDate::isLeapYear)
                .collect(Collectors.toList());

        System.out.println(leapYears);

        LocalDate date1 = LocalDate.of(2000, 1, 1);
        LocalDate date2 = LocalDate.of(2000, 1, 1);

        System.out.println(date1.compareTo(date2));
    }

    private static void localTime() {
        System.out.println(LocalTime.now());

        LocalDate date1 = LocalDate.of(2000, 1, 1);
        LocalDate date2 = LocalDate.of(2000, 1, 1);

        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(10, 30);

        System.out.println(time1.equals(time2));

        LocalDateTime localDateTime1 = LocalDateTime.of(date1, time1);
        LocalDateTime localDateTime2 = LocalDateTime.of(date2, time2);
        System.out.println(localDateTime1.equals(localDateTime2));
    }
}
