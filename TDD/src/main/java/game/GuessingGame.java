package game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1;
    private int guessCounter = 0;

    public String guess(int guessedNumber) {
        ++guessCounter;
        String tryText = guessCounter == 1 ? "try" : "tries";
        String winningMessage = String.format("You got it in %d %s", guessCounter, tryText);
        String responseMessage;

        if (guessCounter == 4 && guessedNumber != getRandomNumber()) {
            responseMessage = String.format("You didn't get it and you've had %d %s. Game over!", guessCounter, tryText);
        } else if (guessCounter > 4) {
            responseMessage = "Sorry, you are limited to only 4 tries. Your game is over!";
        } else {
            String extendingLoseMessage;
            if (guessedNumber < getRandomNumber()) {
                extendingLoseMessage = "- you're too low";
            } else if (guessedNumber > getRandomNumber()) {
                extendingLoseMessage = "- you're too high";
            } else {
                extendingLoseMessage = "";
            }
            String loseMessage = String.format("You didn't get it %s", extendingLoseMessage).trim();
            responseMessage = guessedNumber == getRandomNumber() ? winningMessage : loseMessage;
        }

        return responseMessage;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame guessingGame = new GuessingGame();
        boolean loopShouldContinue = true;

        do {
            String userInput = System.console().readLine("Enter a number: ");
            if ("q".equals(userInput)) {
                return;
            }

            String outputMessage = guessingGame.guess(Integer.parseInt(userInput));
            System.out.println(outputMessage);
            if (outputMessage.contains("You got it") || outputMessage.contains("over")) {
                loopShouldContinue = false;
            }
        } while (loopShouldContinue);
    }
}
