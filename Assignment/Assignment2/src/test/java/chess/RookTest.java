package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

  @Test
  public void testValidMove() {
    chess.Rook r = new chess.Rook(3, 3, chess.Color.WHITE);

    assertTrue(r.canMove(3, 7));
    assertTrue(r.canMove(0, 3));
  }

  @Test
  public void testInvalidMove() {
    chess.Rook r = new chess.Rook(3, 3, chess.Color.WHITE);

    assertFalse(r.canMove(4, 4));
    assertFalse(r.canMove(3, 3));
  }

  @Test
  public void testKill() {
    chess.Rook r = new chess.Rook(3, 3, chess.Color.WHITE);
    chess.ChessPiece enemy = new chess.Pawn(3, 6, chess.Color.BLACK);

    assertTrue(r.canKill(enemy));
    assertFalse(r.canKill(new chess.Pawn(3, 6, chess.Color.WHITE)));
  }
}