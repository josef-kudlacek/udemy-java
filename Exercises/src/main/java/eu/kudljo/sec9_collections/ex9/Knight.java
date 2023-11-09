package eu.kudljo.sec9_collections.ex9;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {

    public Knight(ChessPieceType chessPieceType) {
        super(chessPieceType);
    }

    @Override
    public List<ChessCoordinates> getValidMoves() {
        List<ChessCoordinates> validMoves = new ArrayList<>();

        validMoves.add(getPosition().withOffset(1, calculateRowWithDirection(2))); // north-east
        validMoves.add(getPosition().withOffset(-1, calculateRowWithDirection(2))); // north-west
        validMoves.add(getPosition().withOffset(2, calculateRowWithDirection(1))); // east-north
        validMoves.add(getPosition().withOffset(2, calculateRowWithDirection(-1))); // east-south
        validMoves.add(getPosition().withOffset(-2, calculateRowWithDirection(1))); // west-north
        validMoves.add(getPosition().withOffset(-2, calculateRowWithDirection(-1))); // west-south
        validMoves.add(getPosition().withOffset(1, calculateRowWithDirection(-2))); // south-east
        validMoves.add(getPosition().withOffset(-1, calculateRowWithDirection(-2))); // south-west

        return validMoves;
    }

    @Override
    public String toString() {
        return String.format("Knight{color: %s, position: %s}", getChessPieceType().name(), getPosition());
    }
}
