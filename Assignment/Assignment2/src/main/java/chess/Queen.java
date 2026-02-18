package chess;

public class Queen extends chess.ChessPiece {

  public Queen(int row, int column, chess.Color color) {
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

    int dr = absRowDiff(row);
    int dc = absColDiff(col);

    boolean rookMove = (row == getRow() || col == getColumn());
    boolean bishopMove = (dr == dc);

    return rookMove || bishopMove;
  }
}