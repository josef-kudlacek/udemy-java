package eu.kudljo.sec8_more_oop.ex8;

import java.util.Objects;

public class ChessCoordinates {

    private final int column;
    private final int row;
    private final String coordinatesText;

    public ChessCoordinates(String coordinatesText) {
        this.coordinatesText = coordinatesText;
        this.column = Character.getNumericValue(coordinatesText.charAt(0)) - 10;
        this.row = 8 - Character.getNumericValue(coordinatesText.charAt(1));
    }

    public ChessCoordinates(int column, int row) {
        this.column = column;
        this.row = row;
        this.coordinatesText = getCoordinatesText(column, row);
    }

    public ChessCoordinates withOffset(int column, int row) {
        return new ChessCoordinates(this.column + column, this.row + row);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessCoordinates that = (ChessCoordinates) o;
        return column == that.column && row == that.row && Objects.equals(coordinatesText, that.coordinatesText);
    }

    private String getCoordinatesText(int column, int row) {
        // ASCII a = 97, 0 = 48
        int charColumn = (column + 97 >= 97) ? column + 97 : 48;

        return Character.toString((char) charColumn)
                .concat(String.valueOf(8 - row));
    }

    @Override
    public String toString() {
        return String.format("%s (row: %d; column: %d)", coordinatesText.toUpperCase(), column, row);
    }

    public boolean isPermittedMove(ChessCoordinates[] permittedMoves) {
        for (ChessCoordinates chessCoordinates : permittedMoves) {
            if (chessCoordinates.equals(this))
                return true;
        }

        return false;
    }
}
