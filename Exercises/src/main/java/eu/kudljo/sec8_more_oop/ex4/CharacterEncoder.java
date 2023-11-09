package eu.kudljo.sec8_more_oop.ex4;

public class CharacterEncoder {

    public int encode(char character) {
        int asciiValue = Character.getNumericValue(character);
        if (asciiValue < 10 || asciiValue > 35) {
            return 0;
        }

        // Numeric value for 'a' is 10
        return asciiValue - 9;
    }
}
