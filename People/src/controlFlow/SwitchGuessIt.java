package controlFlow;

import java.util.Random;

public class SwitchGuessIt {
    public static void main(String[] args) {
        // guessGameColored();
        // commandWithSwitch();

        String command = null;

        System.out.printf("%nCommand was: %s%n", command);
        if ("stop".equals(command)) {
            System.out.println("Stopping now...");
        } else if ("go".equals(command)) {
            System.out.println("Going now...");
        } else {
            System.out.println("Command not understood...");
        }
    }

    public static void guessGameColored() {
        System.out.println("- - - WELCOME TO GUESS GAME - - -");
        //int randomNumber = new Random().nextInt(1, 6);
        int randomNumber = new Random().nextInt(5) + 1;
        System.out.printf("Generated number is: %d.%n", randomNumber);

        switch (randomNumber) {
            case 1:
                System.out.println("The color is RED");
                break;
            case 2:
                System.out.println("The color is BLUE");
                break;
            case 3:
                System.out.println("The color is GREEN");
                break;
            case 4:
                System.out.println("The color is PURPLE");
                break;
            default:
                System.out.println("The color is WHATEVER");
                break;
        }
    }

    public static void commandWithSwitch() {
        String command = "go";

        System.out.printf("%nCommand was: %s%n", command);
        // From Java 18 there is case for check null in switch-case
        if (command == null) {
            return;
        }
        switch (command) {
            case "stop":
                System.out.println("Stopping now...");
                break;
            case "go":
                System.out.println("Going now...");
                break;
            default:
                System.out.println("Command not understood...");
        }
    }
}
