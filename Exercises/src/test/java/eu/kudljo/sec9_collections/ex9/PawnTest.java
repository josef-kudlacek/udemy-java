package eu.kudljo.sec9_collections.ex9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnTest extends ChessPieceTest {

    @Test
    public void pawnCanMoveOneForward() {
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        pawn.setPosition(new ChessCoordinates("a2"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a3");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void pawnCanMoveTwoForwardInFirstMove() {
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        pawn.setPosition(new ChessCoordinates("a2"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a4");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void pawnCannotMoveTwoAfterFirstMove() {
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        pawn.setPosition(new ChessCoordinates("a2"));
        pawn.setPosition(new ChessCoordinates("a3"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a5");
        assertFalse(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' was found, but pawn was already moved.", chessCoordinatesExpected));
    }

    @Test
    public void pawnCanMoveOneDiagonallyRight() {
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        pawn.setPosition(new ChessCoordinates("d2"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("e3");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void pawnCanMoveOneDiagonallyLeft() {
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        pawn.setPosition(new ChessCoordinates("d2"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("c3");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void blackPawnCanMoveOneForward() {
        Pawn pawn = new Pawn(ChessPieceType.BLACK);
        pawn.setPosition(new ChessCoordinates("a7"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a6");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void blackPawnCanMoveTwoForwardInFirstMove() {
        Pawn pawn = new Pawn(ChessPieceType.BLACK);
        pawn.setPosition(new ChessCoordinates("a7"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a5");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void blackPawnCannotMoveTwoAfterFirstMove() {
        Pawn pawn = new Pawn(ChessPieceType.BLACK);
        pawn.setPosition(new ChessCoordinates("a7"));
        pawn.setPosition(new ChessCoordinates("a6"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("a4");
        assertFalse(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' was found, but pawn was already moved.", chessCoordinatesExpected));
    }

    @Test
    public void blackPawnCanMoveOneDiagonallyRight() {
        Pawn pawn = new Pawn(ChessPieceType.BLACK);
        pawn.setPosition(new ChessCoordinates("d7"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("e6");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }

    @Test
    public void blackPawnCanMoveOneDiagonallyLeft() {
        Pawn pawn = new Pawn(ChessPieceType.BLACK);
        pawn.setPosition(new ChessCoordinates("d7"));
        List<ChessCoordinates> validMoves = pawn.getValidMoves();

        ChessCoordinates chessCoordinatesExpected = new ChessCoordinates("c6");
        assertTrue(isMoveFoundInList(validMoves, chessCoordinatesExpected),
                String.format("Move '%s' not found.", chessCoordinatesExpected));
    }
}