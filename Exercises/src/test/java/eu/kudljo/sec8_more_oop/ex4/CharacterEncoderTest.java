package eu.kudljo.sec8_more_oop.ex4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterEncoderTest {

    @Test
    public void encoderTestA() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('a');

        assertEquals(1, number);
    }

    @Test
    public void encoderTestB() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('b');

        assertEquals(2, number);
    }

    @Test
    public void encoderTestZ() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('z');

        assertEquals(26, number);
    }

    @Test
    public void encoderTestW() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('w');

        assertEquals(23, number);
    }

    @Test
    public void encoderTestF() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('f');

        assertEquals(6, number);
    }

    @Test
    public void encoderTestC() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('c');

        assertEquals(3, number);
    }

    @Test
    public void encoderTestH() {
        CharacterEncoder characterEncoder = new CharacterEncoder();
        int number = characterEncoder.encode('h');

        assertEquals(8, number);
    }
}
