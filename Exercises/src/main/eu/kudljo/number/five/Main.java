package eu.kudljo.number.five;

import java.util.Random;

public class Main {
    private static int count = 0;
    private static int sum = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(next());
        }
    }

    private static int next() {
        if (count >= 10) {
            throw new RuntimeException();
        }

        ++count;
        Random random = new Random();
        int generatedNumber = random.nextInt(9 - 1) + 1;
        return sum += generatedNumber;
    }
}
