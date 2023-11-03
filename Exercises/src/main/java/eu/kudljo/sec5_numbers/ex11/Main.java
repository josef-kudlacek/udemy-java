package eu.kudljo.sec5_numbers.ex11;

public class Main {
    public static void main(String[] args) {
        System.out.println(getSum("37", "13"));
    }

    private static int getSum(String number1, String number2) {
        return Integer.parseInt(number1) + Integer.parseInt(number2);
    }
}
