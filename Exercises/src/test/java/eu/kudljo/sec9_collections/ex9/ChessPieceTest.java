package eu.kudljo.sec9_collections.ex9;

import java.util.List;

public class ChessPieceTest {

    protected boolean isMoveFoundInList(List<ChessCoordinates> chessCoordinatesPossible, ChessCoordinates chessCoordinatesExpected) {
        for (ChessCoordinates chessCoordinates : chessCoordinatesPossible) {
            if (chessCoordinates.equals(chessCoordinatesExpected))
                return true;
        }

        return false;
    }
}
