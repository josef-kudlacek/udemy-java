package eu.kudljo.controlFlow;

public class Four {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String weekDay : weekDays) {
            if (weekDay.equals("Monday")) {
                System.out.printf("We eat spaghetti on %s%n", weekDay);
            } else if (weekDay.equals("Tuesday")) {
                System.out.printf("We eat tacos on %s%n", weekDay);
            } else if (weekDay.equals("Wednesday")) {
                System.out.printf("We eat chicken on %s%n", weekDay);
            } else if (weekDay.equals("Thursday")) {
                System.out.printf("We eat meatloaf on %s%n", weekDay);
            } else if (weekDay.equals("Friday")) {
                System.out.printf("We eat hamburgers on %s%n", weekDay);
            } else if (weekDay.equals("Saturday")) {
                System.out.printf("We eat pizza on %s%n", weekDay);
            } else if (weekDay.equals("Sunday")) {
                System.out.printf("We eat pot roast on %s%n", weekDay);
            } else {
                System.out.printf("Unexpected value: %s!", weekDay);
            }
        }
    }
}
