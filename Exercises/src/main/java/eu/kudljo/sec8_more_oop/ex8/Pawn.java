package eu.kudljo.sec8_more_oop.ex8;

public class Pawn extends ChessPiece {

    private boolean hasMoved = false;

    public Pawn(ChessPieceType chessPieceType) {
        super(chessPieceType);
    }

    @Override
    public ChessCoordinates[] getValidMoves() {
        int numberOfPossibleMoves = hasMoved ? 3 : 4;
        ChessCoordinates[] validMoves = new ChessCoordinates[numberOfPossibleMoves];

        ChessCoordinates forwardOne = getPosition().withOffset(0, calculateRowWithDirection(1));
        validMoves[0] = forwardOne;

        ChessCoordinates diagonallyRightOne = getPosition().withOffset(1, calculateRowWithDirection(1));
        validMoves[1] = diagonallyRightOne;

        ChessCoordinates diagonallyLeftOne = getPosition().withOffset(-1, calculateRowWithDirection(1));
        validMoves[2] = diagonallyLeftOne;

        if (!hasMoved) {
            ChessCoordinates forwardTwo = getPosition().withOffset(0, calculateRowWithDirection(2));
            validMoves[3] = forwardTwo;
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
