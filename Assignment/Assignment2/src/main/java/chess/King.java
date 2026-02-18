package chess;

public class King extends chess.ChessPiece {

  public King(int row, int column, chess.Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!isInBounds(row, col)) {
      return false;
    }

    int dr = absRowDiff(row);
    int dc = absColDiff(col);

    if (dr == 0 && dc == 0) {
      return false;
    }

    return dr <= 1 && dc <= 1;
  }
}