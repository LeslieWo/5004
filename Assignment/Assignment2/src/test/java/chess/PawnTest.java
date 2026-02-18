package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

  @Test
  public void testWhitePawnMoveForward() {
    chess.Pawn p = new chess.Pawn(2, 3, chess.Color.WHITE);

    assertTrue(p.canMove(3, 3));
    assertFalse(p.canMove(1, 3));
  }

  @Test
  public void testWhitePawnFirstMoveTwoSquares() {
    chess.Pawn p = new chess.Pawn(1, 4, chess.Color.WHITE);

    assertTrue(p.canMove(2, 4));
    assertTrue(p.canMove(3, 4));
  }

  @Test
  public void testBlackPawnMoveForward() {
    chess.Pawn p = new chess.Pawn(6, 2, chess.Color.BLACK);

    assertTrue(p.canMove(5, 2));
    assertTrue(p.canMove(4, 2));
  }

  @Test
  public void testPawnCannotMoveSideways() {
    chess.Pawn p = new chess.Pawn(2, 3, chess.Color.WHITE);

    assertFalse(p.canMove(3, 4));
    assertFalse(p.canMove(2, 4));
  }

  @Test
  public void testPawnKillRule() {
    chess.Pawn whitePawn = new chess.Pawn(3, 3, chess.Color.WHITE);
    chess.ChessPiece enemy = new chess.Knight(4, 4, chess.Color.BLACK);

    assertTrue(whitePawn.canKill(enemy));
    assertFalse(whitePawn.canKill(new chess.Knight(4, 4, chess.Color.WHITE)));
  }

  @Test
  public void testPawnCannotKillStraight() {
    chess.Pawn whitePawn = new chess.Pawn(3, 3, chess.Color.WHITE);
    chess.ChessPiece enemy = new chess.Knight(4, 3, chess.Color.BLACK);

    assertFalse(whitePawn.canKill(enemy));
    assertTrue(whitePawn.canMove(4, 3));
  }

  @Test
  public void testIllegalPawnConstruction() {
    assertThrows(IllegalArgumentException.class, () -> new chess.Pawn(0, 2, chess.Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new chess.Pawn(7, 2, chess.Color.BLACK));
  }
}