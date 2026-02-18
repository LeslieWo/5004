package chess;

public interface ChessPieceContract {

  int getRow();

  int getColumn();

  chess.Color getColor();

  boolean canMove(int row, int col);

  boolean canKill(chess.ChessPiece piece);
}