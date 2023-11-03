package eu.kudljo.sec8_more_oop.ex5;

public class CharacterDecoder {
    public char decode(int numberForDecode) {
        if (numberForDecode > 26 || numberForDecode < 1) {
            return ' ';
        }

        // ASCII value for 'a' is 97
        int asciiNumber = numberForDecode + 96;
        return (char) asciiNumber;
    }
}
