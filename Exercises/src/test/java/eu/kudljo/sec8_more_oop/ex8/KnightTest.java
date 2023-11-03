package eu.kudljo.sec8_more_oop.ex8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class KnightTest extends ChessPieceTest {

    @Test
    public void knightCanMoveNorthEast() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c1"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("d3");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveNorthWest() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c1"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("b3");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveEastNorth() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c1"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("e2");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveEastSouth() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c3"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("e2");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveWestNorth() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c3"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a4");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveWestSouth() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c3"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a2");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveSouthEast() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c3"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("d1");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void knightCanMoveSouthWest() {
        Knight knight = new Knight(ChessPieceType.WHITE);
        knight.setPosition(new ChessCoordinates("c3"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("b1");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void blackKnightCanMoveSouthWest() {
        Knight knight = new Knight(ChessPieceType.BLACK);
        knight.setPosition(new ChessCoordinates("d5"));

        ChessCoordinates[] validMoves = knight.getValidMoves();
        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("c7");
        assertTrue(isMoveFoundInArray(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

}