package controlFlow;

import java.util.Random;

public class WhileLoopGuessIt {
    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(10) + 1;

        while (true) {
            String guessedNumberString = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            int guessedNumber = Integer.parseInt(guessedNumberString);
            if (guessedNumber == randomNumber) {
                System.out.printf("The random number was %d. You got it!%n", randomNumber);
                return;
            } else {
                System.out.printf("You didn't get it. Try again!%n", randomNumber);
            }
        }
    }
}
