package controlFlow;

import java.util.Random;

public class WhileLoopGuessItPartTwo {
    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(10) + 1;
        String guessedNumberString = null;

        while (!("q".equals(guessedNumberString))) {
            guessedNumberString = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumberString.matches("-?\\d{1,2}")) {
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
}
