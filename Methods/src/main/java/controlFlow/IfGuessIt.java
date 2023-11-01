package controlFlow;

import java.util.Random;

public class IfGuessIt {
    public static void main(String[] args) {
        //int randomNumber = new Random().nextInt(1, 6);
        int randomNumber = new Random().nextInt(5) + 1;
        System.out.printf("Generated number is: %d.%n", randomNumber);

        // 1 2 3 4 5
        if (randomNumber < 2) { // 1
            System.out.println("The color is RED!");
        } else if (randomNumber > 4 || (randomNumber % 2 == 0)) { // 2 4 5
            System.out.println("The color is BLUE!");
        } else { // 3
            System.out.println("The color is GREEN!");
        }
    }
}
