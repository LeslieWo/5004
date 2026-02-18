package chess;

public class Bishop extends chess.ChessPiece {

  public Bishop(int row, int column, chess.Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!isInBounds(row, col)) {
      return false;
    }

    int dr = absRowDiff(row);
    int dc = absColDiff(col);

    return dr == dc && dr != 0;
  }
}