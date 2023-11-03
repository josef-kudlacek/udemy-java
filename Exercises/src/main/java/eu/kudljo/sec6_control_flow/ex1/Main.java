package eu.kudljo.sec6_control_flow.ex1;

public class Main {
    public static void main(String[] args) {
//        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Friday", "Saturday", "Sunday"};
//        for (String weekDay : weekDays) {
//            System.out.printf("Current week day is: %s.%n", weekDay.toUpperCase());
//        }

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int index = 0; index < weekDays.length; index++) {
            System.out.printf("Current week day is: %s.%n", index % 2 == 0 ? weekDays[index].toUpperCase() : weekDays[index]);
        }
    }
}
