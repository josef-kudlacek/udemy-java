package controlFlow;

import java.util.Random;

public class DoWhileLoopGuessIt {
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
                    wrongGuessCount++;
                    System.out.printf("You didn't get it. Try again!%n", randomNumber);
                }
            }
        }  while (!("q".equals(guessedNumberString)));
    }
}
