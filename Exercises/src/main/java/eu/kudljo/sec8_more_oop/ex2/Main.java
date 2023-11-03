package eu.kudljo.sec8_more_oop.ex2;

public class Main {
    public static void main(String[] args) {
        for (LunchScheduleType lunch : LunchScheduleType.values()) {
            System.out.println(lunch.toString());
        }
    }
}
