package eu.kudljo.sec6_control_flow.ex2;

public class Main {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int index = 0;
        while (index < weekDays.length) {
            System.out.printf("Current week day is: %s.%n", index % 2 == 0 ? weekDays[index].toUpperCase() : weekDays[index]);
            ++index;
        }
    }
}
