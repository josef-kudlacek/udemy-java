package eu.kudljo.sec9_collections.ex9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {

    @Test
    public void canAddPawn() {
        ChessBoard chessBoard = new ChessBoard();
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        chessBoard.addChessPiece("a2", pawn);

        Pawn foundPawn = (Pawn) chessBoard.getPieceAtCoordinates("a2");
        assertEquals(pawn, foundPawn);
    }

    @Test
    public void canAddKnight() {
        ChessBoard chessBoard = new ChessBoard();
        Knight knight = new Knight(ChessPieceType.BLACK);
        chessBoard.addChessPiece("g8", knight);

        Knight foundKnight = (Knight) chessBoard.getPieceAtCoordinates("g8");
        assertEquals(knight, foundKnight);
    }

    @Test
    public void canKnightMoveFromC1ToD3() {
        ChessBoard chessBoard = new ChessBoard();
        Knight knight = new Knight(ChessPieceType.WHITE);
        chessBoard.addChessPiece("c1", knight);
        assertEquals(knight, chessBoard.getPieceAtCoordinates("c1"), "Knight should start on position C1");

        chessBoard.move("d3", knight);

        assertNull(chessBoard.getPieceAtCoordinates("c1"), "Knight should be moved from position C1");
        assertEquals(knight, chessBoard.getPieceAtCoordinates("d3"), "Knight should be on position D3");
    }

    @Test
    public void cannotKnightMoveFromC1ToInvalidSquare() {
        ChessBoard chessBoard = new ChessBoard();
        Knight knight = new Knight(ChessPieceType.WHITE);
        chessBoard.addChessPiece("c1", knight);
        assertEquals(knight, chessBoard.getPieceAtCoordinates("c1"), "Knight should start on position C1");

        chessBoard.move("d4", knight);

        assertNull(chessBoard.getPieceAtCoordinates("d4"), "Knight should not be moved to position D4");
        assertEquals(knight, chessBoard.getPieceAtCoordinates("c1"), "Knight should stay on position C1");
    }

    @Test
    public void cannotKnightMoveFromC1ToFriendlyOccupiedSquare() {
        ChessBoard chessBoard = new ChessBoard();
        Pawn pawn = new Pawn(ChessPieceType.WHITE);
        chessBoard.addChessPiece("d3", pawn);
        assertEquals(pawn, chessBoard.getPieceAtCoordinates("d3"), "Pawn should be on position D3");

        Knight knight = new Knight(ChessPieceType.WHITE);
        chessBoard.addChessPiece("c1", knight);
        assertEquals(knight, chessBoard.getPieceAtCoordinates("c1"), "Knight should start on position C1");

        chessBoard.move("d3", knight);

        assertEquals(pawn, chessBoard.getPieceAtCoordinates("d3"), "Pawn should be still on position D3");
        assertEquals(knight, chessBoard.getPieceAtCoordinates("c1"), "Knight should be still on position C1");
    }

    @Test
    public void canMoveC1KnightToEnemyOccupiedSquare() {
        ChessBoard chessBoard = new ChessBoard();
        Knight knightWhite = new Knight(ChessPieceType.WHITE);
        chessBoard.addChessPiece("d3", knightWhite);
        assertEquals(knightWhite, chessBoard.getPieceAtCoordinates("d3"), "White Knight should start on position D3");

        Knight knightBlack = new Knight(ChessPieceType.BLACK);
        chessBoard.addChessPiece("c1", knightBlack);
        assertEquals(knightBlack, chessBoard.getPieceAtCoordinates("c1"), "Black Knight should start on position C1");

        chessBoard.move("d3", knightBlack);

        assertTrue(elementExists(chessBoard.getBlackCaptured(), knightWhite), "White Knight should be captured");
        assertEquals(knightBlack, chessBoard.getPieceAtCoordinates("d3"), "Black Knight should be on position D3");
    }

    private boolean elementExists(List list, Object element) {
        for (Object object : list) {
            if (object == element)
                return true;
        }

        return false;
    }
}