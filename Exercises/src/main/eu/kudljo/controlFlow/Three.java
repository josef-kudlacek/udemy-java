package eu.kudljo.controlFlow;

public class Three {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int index = 0;
        do {
            System.out.printf("Current week day is: %s.%n", index % 2 == 0 ? weekDays[index].toUpperCase() : weekDays[index]);
            ++index;
        } while (index < weekDays.length);
    }
}
