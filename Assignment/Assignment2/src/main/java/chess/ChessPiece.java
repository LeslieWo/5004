package chess;

public abstract class ChessPiece implements chess.ChessPieceContract {

  private final int row;
  private final int column;
  private final chess.Color color;

  public ChessPiece(int row, int column, chess.Color color) {
    if (!isInBounds(row, column)) {
      throw new IllegalArgumentException("Position out of bounds.");
    }

    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null.");
    }

    this.row = row;
    this.column = column;
    this.color = color;
  }

  protected boolean isInBounds(int row, int col) {
    return row >= 0 && row <= 7 && col >= 0 && col <= 7;
  }

  protected int rowDiff(int row) {
    return row - this.row;
  }

  protected int colDiff(int col) {
    return col - this.column;
  }

  protected int absRowDiff(int row) {
    return Math.abs(row - this.row);
  }

  protected int absColDiff(int col) {
    return Math.abs(col - this.column);
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return column;
  }

  @Override
  public chess.Color getColor() {
    return color;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) {
      throw new IllegalArgumentException("Target piece cannot be null.");
    }

    if (piece.getColor() == this.color) {
      return false;
    }

    return canMove(piece.getRow(), piece.getColumn());
  }
}