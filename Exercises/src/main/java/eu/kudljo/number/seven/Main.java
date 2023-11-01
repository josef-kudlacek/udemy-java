package eu.kudljo.number.seven;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Main {
    private static NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public static void main(String[] args) throws ParseException {
        String formattedAmount = "$12,345.83";

        System.out.println(getValue(formattedAmount));
    }

    private static String getValue(String formattedAmount) throws ParseException {
        BigDecimal constant = new BigDecimal("32.19");
        BigDecimal amount = new BigDecimal(moneyFormatter.parse(formattedAmount).toString());

        MathContext mathContext = new MathContext(5);
        return moneyFormatter.format(amount.divide(constant, mathContext));
    }
}
