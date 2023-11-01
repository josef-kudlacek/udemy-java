package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessingGameTest {

    private GuessingGame guessingGame;

    @BeforeEach
    void setUp() {
        guessingGame = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNumber = guessingGame.getRandomNumber();
        String guessingResultMessage = guessingGame.guess(randomNumber);

        assertEquals("You got it in 1 try", guessingResultMessage);
    }

    @Test
    public void testOneWrongNegativeGuessSituation() {
        String guessingResultMessage = guessingGame.guess(-5);

        assertEquals("You didn't get it - you're too low", guessingResultMessage);
    }

    @Test
    public void testOneWrongPositiveGuessSituation() {
        int randomNumber = guessingGame.getRandomNumber();
        String guessingResultMessage = guessingGame.guess(randomNumber + 1);

        assertEquals("You didn't get it - you're too high", guessingResultMessage);
    }

    @Test
    public void testRandomNumberGenerationMine() {
        // 1 2 3 4 5 6 7 8 9 10 (generated number interval)
        // 1 1 1 1   1   1 1  1 = 10 (1 for number was generated)
        int[] randomNumberCount = new int[11];
        int tries = 0;
        int checkSum = 0;

        do {
            checkSum = 0;
            ++tries;
            GuessingGame guessingGame = new GuessingGame();
            int randomNumber = guessingGame.getRandomNumber();
            randomNumberCount[randomNumber] = 1;

            for (int arrayIndex = 0; arrayIndex < 11; arrayIndex++) {
                checkSum += randomNumberCount[arrayIndex];
            }
        } while (checkSum != 10);

        System.out.printf("%d is count of generated numbers between 1 and 10 to fulfill interval", tries);
        assertEquals(10, checkSum);
    }

    @Disabled("Test ignored - Hard coded counter for loop for generate all numbers instead of checking used generated numbers")
    @Test
    public void testRandomNumberGenerationFromCourse() {
        // 1 2 3 4 5 6 7 8 9 10 (generated number interval)
        // 1 1 1 1   1   1 1  1 = 10 (1 for number was generated)
        int[] randomNumberCount = new int[11];
        for (int counter = 0; counter < 55; counter++) {
            GuessingGame guessingGame = new GuessingGame();
            int randomNumber = guessingGame.getRandomNumber();
            randomNumberCount[randomNumber] = 1;
        }

        int checkSum = 0;
        for (int arrayIndex = 0; arrayIndex < 11; arrayIndex++) {
            checkSum += randomNumberCount[arrayIndex];
        }
        System.out.println(checkSum);

        assertEquals(10, checkSum);
    }

    @Test
    public void testFourWrongGuesses() {
        makeThreeWrongGuesses();
        String outOfTriesMessage = guessingGame.guess(-3);

        assertEquals("You didn't get it and you've had 4 tries. Game over!", outOfTriesMessage);
    }

    @Test
    public void testTenWrongGuesses() {
        makeThreeWrongGuesses();
        makeThreeWrongGuesses();
        makeThreeWrongGuesses();
        String outOfTriesMessage = guessingGame.guess(-3);

        assertEquals("Sorry, you are limited to only 4 tries. Your game is over!", outOfTriesMessage);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect() {
        makeThreeWrongGuesses();
        int correctAnswer = guessingGame.getRandomNumber();
        String correctGuessMessage = guessingGame.guess(correctAnswer);

        assertEquals("You got it in 4 tries", correctGuessMessage);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        guessingGame.guess(-3);
        guessingGame.guess(-3);
        int correctAnswer = guessingGame.getRandomNumber();
        String correctGuessMessage = guessingGame.guess(correctAnswer);

        assertTrue(correctGuessMessage.contains(" 3 "), "Should indicate 3 tries");
        assertTrue(correctGuessMessage.contains("You got it"), "Should indicate that we got the right number");
    }

    private void makeThreeWrongGuesses() {
        guessingGame.guess(-3);
        guessingGame.guess(-3);
        guessingGame.guess(-3);
    }
}
