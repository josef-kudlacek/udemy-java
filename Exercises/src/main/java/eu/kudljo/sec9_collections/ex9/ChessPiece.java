package eu.kudljo.sec9_collections.ex9;

import java.util.Objects;

public abstract class ChessPiece implements IChessPiece {

    private final ChessPieceType chessPieceType;

    private ChessCoordinates position;

    public ChessPiece(ChessPieceType chessPieceType) {
        this.chessPieceType = chessPieceType;
    }

    @Override
    public ChessPieceType getChessPieceType() {
        return chessPieceType;
    }

    @Override
    public ChessCoordinates getPosition() {
        return position;
    }

    @Override
    public void setPosition(ChessCoordinates position) {
        this.position = position;
    }

    protected int calculateRowWithDirection(int rowOffset) {
        MoveType moveType = (ChessPieceType.WHITE.equals(getChessPieceType())) ?
                MoveType.DOWN : MoveType.UP;

        return rowOffset * moveType.getDirectionValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return chessPieceType == that.chessPieceType && Objects.equals(position, that.position);
    }
}
