package eu.kudljo.sec8_more_oop.ex8;

public class Knight extends ChessPiece {

    public Knight(ChessPieceType chessPieceType) {
        super(chessPieceType);
    }

    @Override
    public ChessCoordinates[] getValidMoves() {
        ChessCoordinates[] validMoves = new ChessCoordinates[8];

        validMoves[0] = getPosition().withOffset(1, calculateRowWithDirection(2)); // north-east
        validMoves[1] = getPosition().withOffset(-1, calculateRowWithDirection(2)); // north-west
        validMoves[2] = getPosition().withOffset(2, calculateRowWithDirection(1)); // east-north
        validMoves[3] = getPosition().withOffset(2, calculateRowWithDirection(-1)); // east-south
        validMoves[4] = getPosition().withOffset(-2, calculateRowWithDirection(1)); // west-north
        validMoves[5] = getPosition().withOffset(-2, calculateRowWithDirection(-1)); // west-south
        validMoves[6] = getPosition().withOffset(1, calculateRowWithDirection(-2)); // south-east
        validMoves[7] = getPosition().withOffset(-1, calculateRowWithDirection(-2)); // south-west

        return validMoves;
    }

    @Override
    public String toString() {
        return String.format("Knight{color: %s, position: %s}", getChessPieceType().name(), getPosition());
    }
}
