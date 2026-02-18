package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

  @Test
  public void testValidMove() {
    chess.Knight k = new chess.Knight(4, 4, chess.Color.WHITE);

    assertTrue(k.canMove(6, 5));
    assertTrue(k.canMove(5, 6));
  }

  @Test
  public void testInvalidMove() {
    chess.Knight k = new chess.Knight(4, 4, chess.Color.WHITE);

    assertFalse(k.canMove(4, 5));
    assertFalse(k.canMove(7, 7));
  }

  @Test
  public void testKill() {
    chess.Knight k = new chess.Knight(4, 4, chess.Color.WHITE);
    chess.ChessPiece enemy = new chess.Pawn(6, 5, chess.Color.BLACK);

    assertTrue(k.canKill(enemy));
    assertFalse(k.canKill(new chess.Pawn(6, 5, chess.Color.WHITE)));
  }
}