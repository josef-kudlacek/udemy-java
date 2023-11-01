package eu.kudljo.controlFlow;

public class Six {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String weekDay : weekDays) {
            String meal = switch (weekDay) {
                case "Monday" -> "spaghetti";
                case "Tuesday" -> "tacos";
                case "Wednesday" -> "chicken";
                case "Thursday" -> "meatloaf";
                case "Friday" -> "hamburgers";
                case "Saturday" -> "pizza";
                case "Sunday" -> "pot roast";
                default -> "unexpected value";
            };

            System.out.printf("We eat %s on %s%n", formatMealName(meal), weekDay);
        }
    }

    private static String formatMealName(String mealName) {
        String[] words = mealName.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < words.length;) {
            String word = words[index];
            stringBuilder.append(word.substring(0, 1).toUpperCase());
            stringBuilder.append(word.substring(1));

            if (++index < words.length) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
