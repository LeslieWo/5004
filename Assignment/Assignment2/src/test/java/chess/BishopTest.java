package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {

  @Test
  public void testDiagonalMove() {
    chess.Bishop b = new chess.Bishop(4, 4, chess.Color.WHITE);

    assertTrue(b.canMove(6, 6));
    assertTrue(b.canMove(2, 2));
  }

  @Test
  public void testInvalidMove() {
    chess.Bishop b = new chess.Bishop(4, 4, chess.Color.WHITE);

    assertFalse(b.canMove(4, 7));
    assertFalse(b.canMove(5, 4));
  }

  @Test
  public void testCanKill() {
    chess.Bishop b = new chess.Bishop(4, 4, chess.Color.WHITE);
    chess.ChessPiece enemy = new chess.Pawn(5, 5, chess.Color.BLACK);

    assertTrue(b.canKill(enemy));
    assertFalse(b.canMove(5, 4));
  }
}