package lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

  @Test
  public void testConstructorDoesNotThrow() {
    assertDoesNotThrow(() -> new lab3.Triangle(0, 0, 1, 0, 0, 1));
    assertDoesNotThrow(() -> new lab3.Triangle(-1, -1, 2, 0, 0, 2));
  }

  @Test
  public void testConstructorThrowsForDuplicatePoints() {
    assertThrows(IllegalArgumentException.class,
        () -> new lab3.Triangle(0, 0, 0, 0, 1, 1));

    assertThrows(IllegalArgumentException.class,
        () -> new lab3.Triangle(1, 1, 2, 2, 2, 2));
  }

  @Test
  public void testPerimeter() {
    lab3.Triangle t = new lab3.Triangle(0, 0, 3, 0, 0, 4);

    assertEquals(12.0, t.perimeter(), 0.000001);
    assertNotEquals(11.0, t.perimeter(), 0.000001);
  }

  @Test
  public void testAreaRightTriangle() {
    lab3.Triangle t = new lab3.Triangle(0, 0, 3, 0, 0, 4);

    assertEquals(6.0, t.area(), 0.000001);
    assertNotEquals(7.0, t.area(), 0.000001);
  }

  @Test
  public void testAreaCollinearIsZero() {
    lab3.Triangle t = new lab3.Triangle(0, 0, 1, 1, 2, 2);

    assertEquals(0.0, t.area(), 0.000001);
    assertTrue(t.perimeter() > 0);
  }

  @Test
  public void testReferencePointIsFirstPoint() {
    lab3.Triangle t = new lab3.Triangle(5, 6, 1, 2, 3, 4);

    assertEquals(5.0, t.getReferencePoint().getX(), 0.000001);
    assertEquals(6.0, t.getReferencePoint().getY(), 0.000001);
  }

  @Test
  public void testToString() {
    lab3.Triangle t = new lab3.Triangle(0, 0, 1, 0, 0, 1);

    assertTrue(t.toString().contains("Triangle"));
    assertTrue(t.toString().contains("p1="));
  }
}