package datastore;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2000, 1, 1);
        LocalTime time1 = LocalTime.of(10, 30);
        LocalDateTime localDateTime1 = LocalDateTime.of(date1, time1);

        System.out.println(ZonedDateTime.of(localDateTime1, ZoneId.of("-5")));

        LocalDateTime xmas = LocalDateTime.of(2021, 12, 25, 20, 00);
        // California - GMT-08
        ZonedDateTime zxmas = ZonedDateTime.of(xmas, ZoneId.of("-8"));
        System.out.println(zxmas.withZoneSameInstant(ZoneId.of("+0")));
    }

    private static void timeBetween() {
        LocalDate date1 = LocalDate.of(2000, 1, 1);
        LocalDate date2 = LocalDate.of(2002, 6, 1);

        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(10, 57, 39);

        Period difference = Period.between(date2, date1);
        System.out.printf("%d years, %d months, %d days%n",
                difference.getYears(), difference.getMonths(), difference.getDays()); // -2 years, -5 months, 0 days

        System.out.println(Duration.between(time1, time2).toMinutesPart());
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
