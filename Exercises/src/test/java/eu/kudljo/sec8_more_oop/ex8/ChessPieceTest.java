package eu.kudljo.sec8_more_oop.ex8;

public class ChessPieceTest {

    protected boolean isMoveFoundInArray(ChessCoordinates[] chessCoordinatesPossible, ChessCoordinates chessCoordinatesExpected) {
        for (ChessCoordinates chessCoordinates : chessCoordinatesPossible) {
            if (chessCoordinates.equals(chessCoordinatesExpected))
                return true;
        }

        return false;
    }
}
