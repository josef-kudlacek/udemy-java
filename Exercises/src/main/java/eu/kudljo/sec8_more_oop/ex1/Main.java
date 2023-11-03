package eu.kudljo.sec8_more_oop.ex1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%nPrint with first letter capitalized:%n");
        for (DayOfWeekType day : DayOfWeekType.values()) {
            System.out.println(day);
        }

        System.out.printf("%nPrint with capitalized first letter or middle letter:%n");
        for (int enumIndex = 0; enumIndex < DayOfWeekType.values().length; enumIndex++) {
            if (enumIndex % 2 == 0) {
                System.out.printf("%s%n", DayOfWeekType.values()[enumIndex].toString());
            } else {
                System.out.printf("%s%n", DayOfWeekType.values()[enumIndex].print());
            }
        }

        System.out.printf("%nPrint 10 random days of the week:%n");
        for (int counter = 0; counter < 10; counter++) {
            int randomNumber = new Random().nextInt(7);
            System.out.printf("%s%n", DayOfWeekType.values()[randomNumber]);
        }
    }
}
