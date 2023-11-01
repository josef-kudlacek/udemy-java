package eu.kudljo.controlFlow;

public class Five {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String weekDay : weekDays) {
            switch (weekDay) {
                case "Monday":
                    System.out.printf("We eat spaghetti on %s%n", weekDay);
                    break;
                case "Tuesday":
                    System.out.printf("We eat tacos on %s%n", weekDay);
                    break;
                case "Wednesday":
                    System.out.printf("We eat chicken on %s%n", weekDay);
                    break;
                case "Thursday":
                    System.out.printf("We eat meatloaf on %s%n", weekDay);
                    break;
                case "Friday":
                    System.out.printf("We eat hamburgers on %s%n", weekDay);
                    break;
                case "Saturday":
                    System.out.printf("We eat pizza on %s%n", weekDay);
                    break;
                case "Sunday":
                    System.out.printf("We eat pot roast on %s%n", weekDay);
                    break;
                default:
                    System.out.printf("Unexpected value: %s!", weekDay);
                    break;
            }
        }
    }
}
