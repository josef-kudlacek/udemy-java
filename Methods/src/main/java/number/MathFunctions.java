package number;

public class MathFunctions {
    public static void main(String[] args) {
        System.out.println("absolute:");
        System.out.println(Math.abs(-5));
        System.out.println("ceiling:");
        System.out.println(Math.ceil(5.0)); // 5
        System.out.println(Math.ceil(5.01)); // 6; rounding up to ceiling
        System.out.println(Math.ceil(5.6)); // 6; rounding up to ceiling
        System.out.println("floor:");
        System.out.println(Math.floor(5.999)); // 5; rounding down
        System.out.println(Math.floor(5.6)); // 6; rounding down
        System.out.println(Math.floor(5.01)); // 6; rounding down
        int num1 = 3;
        int num2 = 5;
        System.out.println("Minimum is: " + Math.min(num1, num2));
        System.out.println("Maximum is: " + Math.max(num1, num2));
        System.out.println("Powering: " + Math.pow(2, 3)); // 2^3; result is in double
        System.out.println("Random number: " + (int)(Math.random() * 10)); // range 0-10
        System.out.println("Rounding number: " + Math.round(5.0));
        System.out.println("Rounding number: " + Math.round(5.2));
        System.out.println("Rounding number: " + Math.round(5.49));
        System.out.println("Rounding number: " + Math.round(5.52));
        System.out.println("Rounding number: " + Math.round(5.999));
        System.out.println("Square root of: " + Math.sqrt(81));
        System.out.println("Constants:");
        System.out.println(Math.PI);
        System.out.println(Math.E); // Euler's number
    }
}
