package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void canAddZeroPlusZero() {
        int sum = calculator.add(0, 0);

        assertEquals(0, sum, "Was expecting sum of 0");
    }

    @Test
    public void canAddOnePlusOne() {
        int sum = calculator.add(1, 1);

        assertEquals(2, sum);
    }

    @Test
    public void canAddNegativePlusPositive() {
        int sum = calculator.add(-1, 1);

        assertEquals(0, sum);
    }

    @Test
    public void canAddPositivePlusNegative() {
        int sum = calculator.add(1, -1);

        assertEquals(0, sum);
    }

    @Test
    public void canAddNegativePlusNegative() {
        int sum = calculator.add(-1, -1);

        assertEquals(-2, sum);
    }

    // @Ignore is not used now
    @Disabled("Handling calculation of more then integer value is not covered by course")
    @Test
    public void canAddMaxIntPlusOne() {
        int sum = calculator.add(Integer.MAX_VALUE, 1);
        System.out.println(sum); // 2147483647

        assertEquals(Integer.MAX_VALUE + 1L, sum);
    }

    @Test
    public void annuityExample() {
        String answer = calculator.calculateAnnuity("22000", 7, ".06", 1);

        assertEquals("$184,664.43", answer);
    }

    @Test
    public void annuityPractice2() {
        String answer = calculator.calculateAnnuity("1200", 10, ".08", 4);

        assertEquals("$72,482.38", answer);
    }
}
