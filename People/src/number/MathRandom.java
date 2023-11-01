package number;

import java.security.SecureRandom;
import java.util.Random;

public class MathRandom {
    public static void main(String[] args) {
        Random random = new Random(); // using default constructor without seed
        System.out.println(random.nextInt()); // range from 2 to 10
        System.out.println(random.nextInt(10 - 2) + 2); // range from 2 to 10
        System.out.println(random.nextInt(10 - 2) + 2); // range from 2 to 10

        SecureRandom secureRandom = new SecureRandom(); // This class provides a cryptographically strong random number generator (RNG)
        System.out.println("Special random:");
        System.out.println(secureRandom.nextInt(10));
        System.out.println(secureRandom.nextInt(10));
        System.out.println(secureRandom.nextInt(10));
        System.out.println(secureRandom.nextInt(10));
    }
}
