package eu.kudljo.sec9_collections.ex9;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private final IChessPiece[][] board = new IChessPiece[8][8];
    private final List<IChessPiece> whiteCaptured = new ArrayList<>();
    private final List<IChessPiece> blackCaptured = new ArrayList<>();

    public void addChessPiece(String coordinatesText, IChessPiece piece) {
        ChessCoordinates chessCoordinates = new ChessCoordinates(coordinatesText);
        piece.setPosition(chessCoordinates);
        board[chessCoordinates.getColumn()][chessCoordinates.getRow()] = piece;
    }


    public IChessPiece getPieceAtCoordinates(String coordinatesText) {
        if (coordinatesText.length() != 2) {
            return null;
        }

        ChessCoordinates chessCoordinates = new ChessCoordinates(coordinatesText);
        return board[chessCoordinates.getColumn()][chessCoordinates.getRow()];
    }

    public void move(String chessCoordinatesText, IChessPiece chessPiece) {
        ChessCoordinates chessCoordinatesOrigin = chessPiece.getPosition();
        ChessCoordinates chessCoordinatesDestination = new ChessCoordinates(chessCoordinatesText);

        if (destinationIsOccupiedByFriendly(chessPiece, chessCoordinatesDestination)) {
            return;
        } else if (destinationIsOccupiedByEnemy(chessPiece, chessCoordinatesDestination)) {
            IChessPiece chessPieceCaptured = getPieceAtCoordinates(chessCoordinatesText);
            chessPieceCaptured.setPosition(null);
            if (ChessPieceType.WHITE.equals(chessPiece.getChessPieceType())) {
                whiteCaptured.add(chessPieceCaptured);
            } else {
                blackCaptured.add(chessPieceCaptured);
            }
        }

        performMove(chessPiece, chessCoordinatesText, chessCoordinatesOrigin, chessCoordinatesDestination);
    }

    public List<IChessPiece> getWhiteCaptured() {
        return whiteCaptured;
    }

    public List<IChessPiece> getBlackCaptured() {
        return blackCaptured;
    }

    private boolean destinationIsOccupiedByFriendly(IChessPiece chessPiece, ChessCoordinates chessCoordinatesDestination) {
        IChessPiece chessPieceDestination = this.board[chessCoordinatesDestination.getColumn()][chessCoordinatesDestination.getRow()];
        return chessPieceDestination != null && chessPieceDestination.getChessPieceType().equals(chessPiece.getChessPieceType());
    }

    private boolean destinationIsOccupiedByEnemy(IChessPiece chessPiece, ChessCoordinates chessCoordinatesDestination) {
        IChessPiece chessPieceDestination = this.board[chessCoordinatesDestination.getColumn()][chessCoordinatesDestination.getRow()];
        return chessPieceDestination != null && !chessPieceDestination.getChessPieceType().equals(chessPiece.getChessPieceType());
    }

    private void performMove(IChessPiece chessPiece,
                             String chessCoordinatesText,
                             ChessCoordinates chessCoordinatesOrigin,
                             ChessCoordinates chessCoordinatesDestination) {
        if (chessCoordinatesDestination.isPermittedMove(chessPiece.getValidMoves())) {
            this.board[chessCoordinatesOrigin.getColumn()][chessCoordinatesOrigin.getRow()] = null;
            addChessPiece(chessCoordinatesText, chessPiece);
        }
    }
}
