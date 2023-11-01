package controlFlow;

import java.util.Random;

public class DoWhileLoopGuessItPartTwo {
    private static final int MAX_ALLOWED_TRIED = 4;

    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNumber);
        String guessedNumberString = null;
        int wrongGuessCount = 1;

        do {
            guessedNumberString = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumberString.matches("-?\\d{1,2}")) {
                int guessedNumber = Integer.parseInt(guessedNumberString);
                if (guessedNumber == randomNumber) {
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    System.out.printf("The random number was %d. You got it in %d %s!%n", randomNumber, wrongGuessCount, tryText);
                    return;
                } else {
                    System.out.printf("You didn't get it. Try again!%n");
                    wrongGuessCount++;
                }
            }
        } while (!("q".equals(guessedNumberString)) && wrongGuessCount <= MAX_ALLOWED_TRIED);
        // didn't press q = 1, less than 4 wrong guesses = 1 --> loop continues
        // didn't press q = 1, more than 4 wrong guesses = 0 --> loop stops
        // DID press q = 0, less than 4 wrong guesses = 1 --> loop stops
        // DID press q = 0, more than 4 wrong guesses = 0 --> loop stops

        if (wrongGuessCount >= MAX_ALLOWED_TRIED) {
            System.out.printf("You reached maximum (%d) number of incorrect guessing!" +
                    "%nRandom number was: %d.%n", --wrongGuessCount, randomNumber);
        }
    }
}
