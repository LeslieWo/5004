package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

  @Test
  public void testValidMove() {
    Queen q = new Queen(4, 4, Color.WHITE);

    assertTrue(q.canMove(4, 7)); // horizontal
    assertTrue(q.canMove(7, 7)); // diagonal
  }

  @Test
  public void testInvalidMove() {
    Queen q = new Queen(4, 4, Color.WHITE);

    assertFalse(q.canMove(6, 5));
    assertFalse(q.canMove(4, 4));
  }

  @Test
  public void testKill() {
    Queen q = new Queen(4, 4, Color.WHITE);
    ChessPiece enemy = new Pawn(7, 7, Color.BLACK);

    assertTrue(q.canKill(enemy));
    assertFalse(q.canKill(new Pawn(7, 7, Color.WHITE)));
  }
}