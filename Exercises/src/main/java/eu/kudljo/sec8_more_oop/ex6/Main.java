package eu.kudljo.sec8_more_oop.ex6;

public class Main {
    public static void main(String[] args) {
        int number1 = 8;
        System.out.printf("Number %d transformed to: %d.%n", number1, getNumber(number1));
        int number2 = 7;
        System.out.printf("Number %d transformed to: %d.%n", number2, getNumber(number2));
        int number3 = 6;
        System.out.printf("Number %d transformed to: %d.%n", number3, getNumber(number3));
        int number4 = 5;
        System.out.printf("Number %d transformed to: %d.%n", number4, getNumber(number4));
        int number5 = 4;
        System.out.printf("Number %d transformed to: %d.%n", number5, getNumber(number5));
        int number6 = 3;
        System.out.printf("Number %d transformed to: %d.%n", number6, getNumber(number6));
        int number7 = 2;
        System.out.printf("Number %d transformed to: %d.%n", number7, getNumber(number7));
        int number8 = 1;
        System.out.printf("Number %d transformed to: %d.%n", number8, getNumber(number8));
    }

    public static int getNumber(int number) {
        return 8 - number;
    }
}
