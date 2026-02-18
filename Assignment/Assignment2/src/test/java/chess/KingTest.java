package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

  @Test
  public void testValidMove() {
    King k = new King(4, 4, Color.WHITE);

    assertTrue(k.canMove(5, 5));
    assertTrue(k.canMove(4, 5));
  }

  @Test
  public void testInvalidMove() {
    King k = new King(4, 4, Color.WHITE);

    assertFalse(k.canMove(6, 6));
    assertFalse(k.canMove(4, 4));
  }

  @Test
  public void testKill() {
    King k = new King(4, 4, Color.WHITE);
    ChessPiece enemy = new Pawn(5, 5, Color.BLACK);

    assertTrue(k.canKill(enemy));
    assertFalse(k.canKill(new Pawn(5, 5, Color.WHITE)));
  }
}