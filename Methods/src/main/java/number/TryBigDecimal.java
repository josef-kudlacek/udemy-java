package number;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class TryBigDecimal {
    public static void main(String[] args) {
        float num1 = 2.15f;
        float num2 = 1.10f;

        System.out.println(num1 - num2);

        // creating BigDecimal
        BigDecimal num3 = new BigDecimal("2.15");
        BigDecimal num4 = new BigDecimal("1.10");
        System.out.println(num3.subtract(num4));

        // operations with BigDecimal
        MathContext mathContext = new MathContext(1, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal(".03145683").divide(new BigDecimal("5.321"), mathContext));
        System.out.println(new BigDecimal(".054145683").sqrt( mathContext));
        System.out.println(new BigDecimal(".03145683").min(new BigDecimal("5.321")));
        System.out.println(new BigDecimal("-7").abs());
        System.out.println(new BigDecimal("10").remainder(new BigDecimal("8")));

        // larger data type for number then long
        BigInteger bigInteger = new BigInteger("1215461231998");
        // 3.141592 -> 3141592
        System.out.println(bigInteger);
    }
}
