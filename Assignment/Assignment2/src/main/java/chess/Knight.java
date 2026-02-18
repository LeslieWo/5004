package chess;

public class Knight extends chess.ChessPiece {

  public Knight(int row, int column, chess.Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!isInBounds(row, col)) {
      return false;
    }

    int dr = absRowDiff(row);
    int dc = absColDiff(col);

    return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
  }
}