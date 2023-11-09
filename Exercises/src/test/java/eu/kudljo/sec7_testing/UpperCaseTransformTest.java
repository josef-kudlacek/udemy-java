package eu.kudljo.sec7_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpperCaseTransformTest {

    private UpperCaseTransform upperCaseTransform = new UpperCaseTransform();

    @Test
    public void testTwoCharString() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase("ab");

        assertEquals("aB", outputWithOtherUpper);
    }

    @Test
    public void testThreeCharString() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase("cat");

        assertEquals("cAt", outputWithOtherUpper);
    }

    @Test
    public void testFiveCharString() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase("apple");

        assertEquals("aPpLe", outputWithOtherUpper);
    }

    @Test
    public void testFiveCharStringWithNumber() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase("apple22");

        assertEquals("aPpLe22", outputWithOtherUpper);
    }

    @Test
    public void testStringWithNumber() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase("0");

        assertEquals("0", outputWithOtherUpper);
    }

    @Test
    public void testEmptyString() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase("");

        assertEquals("", outputWithOtherUpper);
    }

    @Test
    public void testFiveCharStringWithSpaces() {
        String outputWithOtherUpper = upperCaseTransform.toUpperCase(" ap ple 2a2. B");

        assertEquals(" Ap pLe 2A2. B", outputWithOtherUpper);
    }
}
