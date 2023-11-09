package eu.kudljo.sec8_more_oop.ex8;

public interface IChessPiece {

    ChessCoordinates getPosition();

    void setPosition(ChessCoordinates chessCoordinates);

    ChessPieceType getChessPieceType();

    ChessCoordinates[] getValidMoves();
}
