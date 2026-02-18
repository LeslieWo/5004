package chess;

public class Pawn extends chess.ChessPiece {

  public Pawn(int row, int column, chess.Color color) {
    super(row, column, color);

    // Special rule: no pawn can be created on its "royal row"
    if (color == chess.Color.WHITE && row == 0) {
      throw new IllegalArgumentException("White pawn cannot be created on row 0.");
    }

    if (color == chess.Color.BLACK && row == 7) {
      throw new IllegalArgumentException("Black pawn cannot be created on row 7.");
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!isInBounds(row, col)) {
      return false;
    }

    int currentRow = getRow();
    int currentCol = getColumn();

    // Pawn cannot move sideways
    if (col != currentCol) {
      return false;
    }

    if (getColor() == chess.Color.WHITE) {
      // normal move forward 1
      if (row == currentRow + 1) {
        return true;
      }

      // start row can move 2
      if (currentRow == 1 && row == currentRow + 2) {
        return true;
      }
    } else { // BLACK
      if (row == currentRow - 1) {
        return true;
      }

      if (currentRow == 6 && row == currentRow - 2) {
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean canKill(chess.ChessPiece piece) {
    if (piece == null) {
      throw new IllegalArgumentException("Target piece cannot be null.");
    }

    if (piece.getColor() == this.getColor()) {
      return false;
    }

    int targetRow = piece.getRow();
    int targetCol = piece.getColumn();

    int dr = targetRow - getRow();
    int dc = Math.abs(targetCol - getColumn());

    if (dc != 1) {
      return false;
    }

    if (getColor() == chess.Color.WHITE) {
      return dr == 1;
    } else {
      return dr == -1;
    }
  }
}