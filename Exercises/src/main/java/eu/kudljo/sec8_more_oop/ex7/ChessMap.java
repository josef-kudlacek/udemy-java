package eu.kudljo.sec8_more_oop.ex7;

public class ChessMap {
    public int[] getCoordinates(String inputText) {
        if (inputText.length() != 2) {
            return null;
        }

        int row = Character.getNumericValue(inputText.charAt(0)) - 10;
        int column = 8 - Character.getNumericValue(inputText.charAt(1));
        return new int[]{row, column};
    }
}
