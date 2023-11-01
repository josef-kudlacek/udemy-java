package controlFlow;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

public class ForLoopGuessIt {
    private static final int MAX_ALLOWED_TRIED = 4;

    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNumber);
        String guessedNumberString = null;
        int wrongGuessCount = 1;

        for (; wrongGuessCount <= MAX_ALLOWED_TRIED; wrongGuessCount++) {
            guessedNumberString = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumberString.matches("-?\\d{1,2}")) {
                int guessedNumber = Integer.parseInt(guessedNumberString);
                if (guessedNumber == randomNumber) {
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    System.out.printf("The random number was %d. You got it in %d %s!%n", randomNumber, wrongGuessCount, tryText);
                    break; // 'return;' will end whole program in main method
                } else {
                    if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                        System.out.printf("You didn't get it. Try again!%n");
                        continue;
                    }

                    System.out.println("You REALLY REALLY didn't get it. You're quite terrible in guessing.");
                    System.out.println("You REALLY REALLY didn't get it. You're quite terrible in guessing.");
                    System.out.println("You REALLY REALLY didn't get it. You're quite terrible in guessing.");
                    System.out.println("You REALLY REALLY didn't get it. You're quite terrible in guessing.");
                    System.out.println("You REALLY REALLY didn't get it. You're quite terrible in guessing.");
                }
            }
        }

        if (wrongGuessCount >= MAX_ALLOWED_TRIED) {
            System.out.printf("You reached maximum (%d) number of incorrect guessing!" +
                    "%nRandom number was: %d.%n", --wrongGuessCount, randomNumber);
        }
        System.out.println("Program ended");
    }
}
