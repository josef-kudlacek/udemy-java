package eu.kudljo.sec6_control_flow.ex7;

public class Main {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int totalCharCounter = 0;

        for (String weekDay : weekDays) {
            totalCharCounter += weekDay.length();
        }

        System.out.printf("Total eu.kudljo.number of characters is: %d", totalCharCounter);
    }
}
