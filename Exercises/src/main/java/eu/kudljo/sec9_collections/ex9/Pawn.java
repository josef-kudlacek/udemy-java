package eu.kudljo.sec9_collections.ex9;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece {

    private boolean hasMoved = false;

    public Pawn(ChessPieceType chessPieceType) {
        super(chessPieceType);
    }

    @Override
    public List<ChessCoordinates> getValidMoves() {
        List<ChessCoordinates> validMoves = new ArrayList<>();

        ChessCoordinates forwardOne = getPosition().withOffset(0, calculateRowWithDirection(1));
        validMoves.add(forwardOne);

        ChessCoordinates diagonallyRightOne = getPosition().withOffset(1, calculateRowWithDirection(1));
        validMoves.add(diagonallyRightOne);

        ChessCoordinates diagonallyLeftOne = getPosition().withOffset(-1, calculateRowWithDirection(1));
        validMoves.add(diagonallyLeftOne);

        if (!hasMoved) {
            ChessCoordinates forwardTwo = getPosition().withOffset(0, calculateRowWithDirection(2));
            validMoves.add(forwardTwo);
        }

        return validMoves;
    }

    @Override
    public void setPosition(ChessCoordinates position) {
        if (this.getPosition() != null) {
            hasMoved = true;
        }

        super.setPosition(position);
    }

    @Override
    public String toString() {
        return String.format("Pawn{color: %s, position: %s}", getChessPieceType().name(), getPosition());
    }
}
