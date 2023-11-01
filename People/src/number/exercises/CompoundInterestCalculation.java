package number.exercises;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompoundInterestCalculation {

    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    private static final NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.US);

    public static void main(String[] args) throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("$,###.####;$(#)"); // limited for Zone of server, semicolon for separate positive and negative number
        DecimalFormat percentFormat = new DecimalFormat("#.##%");
        BigDecimal balance = calculate("$25,300.00", "8%", 10, "$7,500");
        System.out.println(moneyFormatter.format(balance));
        System.out.println(decimalFormat.format(balance.negate()));
        System.out.println(percentFormat.format(10.0825));

        String customMoneyFormat = String.format("$%,(.2f%n", balance); // printf just using flags for turn on/off formatting:
        // like 3 number places, negative number, decimal places and new line
        System.out.println(customMoneyFormat);
    }

    /**
     * This method calculates compound interest.
     * Formula: Balance(Y) = P(1 + r)^Y + c[((1 + r)^Y - 1)/r]
     * @param principal
     * @param rate
     * @param period
     * @param contribution
     * @return
     */
    public static BigDecimal calculate(String principal, String rate, int period, String contribution) throws ParseException {
        String rateAsPercent = percentFormatter.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)); // (1 + r)
        BigDecimal b = a.pow(period); // (1 + r)^Y
        BigDecimal c = b.subtract(BigDecimal.ONE); // ((1 + r)^Y - 1)
        BigDecimal d = c.divide(new BigDecimal(rateAsPercent)); // ((1 + r)^Y - 1) / r
        BigDecimal e = d.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString())); // c[((1 + r)^Y - 1) / r]
        BigDecimal f = b.multiply(new BigDecimal(moneyFormatter.parse(principal).toString())); // P(1 + r)^Y
        return f.add(e); // P(1 + r)^Y + c[((1 + r)^Y - 1)/r]
    }
}
