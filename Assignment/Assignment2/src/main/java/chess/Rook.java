package chess;

public class Rook extends chess.ChessPiece {

  public Rook(int row, int column, chess.Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!isInBounds(row, col)) {
      return false;
    }

    if (row == getRow() && col == getColumn()) {
      return false;
    }

    return row == getRow() || col == getColumn();
  }
}