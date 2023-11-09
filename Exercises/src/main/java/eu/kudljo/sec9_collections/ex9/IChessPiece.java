package eu.kudljo.sec9_collections.ex9;

import java.util.List;

public interface IChessPiece {

    ChessCoordinates getPosition();

    void setPosition(ChessCoordinates chessCoordinates);

    ChessPieceType getChessPieceType();

    List<ChessCoordinates> getValidMoves();
}
