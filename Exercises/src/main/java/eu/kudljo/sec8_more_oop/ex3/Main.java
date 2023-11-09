package eu.kudljo.sec8_more_oop.ex3;

import eu.kudljo.sec8_more_oop.ex2.LunchScheduleType;

public class Main {
    public static void main(String[] args) {
        String input = "friday, thursday, monday, saturday, tuesday";

        System.out.println(getMealsForDays(input));
    }

    public static String getMealsForDays(String input) {
        String[] days = input.split(", ");
        StringBuilder meals = new StringBuilder();
        for (int dayIndex = 0; dayIndex < days.length; dayIndex++) {
            meals.append(LunchScheduleType.valueOf(days[dayIndex].toUpperCase()).getMeal());
            if (dayIndex < days.length - 1) {
                meals.append(", ");
            }
        }

        return meals.toString();
    }
}
