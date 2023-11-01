package eu.kudljo.number.six;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main {
    private static NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        String input = "149.32";
        System.out.println(formatToMoney(input));
    }

    private static String formatToMoney(String amount) {
        BigDecimal money = new BigDecimal(amount);
        return moneyFormat.format(money);
    }
}
