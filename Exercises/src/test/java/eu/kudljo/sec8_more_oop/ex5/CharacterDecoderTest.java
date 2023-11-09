package eu.kudljo.sec8_more_oop.ex5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterDecoderTest {

    @Test
    public void decodeNumber1() {
        CharacterDecoder characterDecoder = new CharacterDecoder();
        char output = characterDecoder.decode(1);
        assertEquals('a', output);
    }

    @Test
    public void decodeNumber26() {
        CharacterDecoder characterDecoder = new CharacterDecoder();
        char output = characterDecoder.decode(26);
        assertEquals('z', output);
    }

    @Test
    public void decodeNumber23() {
        CharacterDecoder characterDecoder = new CharacterDecoder();
        char output = characterDecoder.decode(23);
        assertEquals('w', output);
    }

    @Test
    public void decodeNumber6() {
        CharacterDecoder characterDecoder = new CharacterDecoder();
        char output = characterDecoder.decode(6);
        assertEquals('f', output);
    }

    @Test
    public void decodeNumber3() {
        CharacterDecoder characterDecoder = new CharacterDecoder();
        char output = characterDecoder.decode(3);
        assertEquals('c', output);
    }

    @Test
    public void decodeNumber8() {
        CharacterDecoder characterDecoder = new CharacterDecoder();
        char output = characterDecoder.decode(8);
        assertEquals('h', output);
    }
}
