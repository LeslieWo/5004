package lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

  @Test
  public void testArea() {
    lab3.Rectangle r = new lab3.Rectangle(0, 0, 3, 4);

    assertEquals(12.0, r.area(), 0.000001);
    assertNotEquals(10.0, r.area(), 0.000001);
  }

  @Test
  public void testPerimeter() {
    lab3.Rectangle r = new lab3.Rectangle(0, 0, 3, 4);

    assertEquals(14.0, r.perimeter(), 0.000001);
    assertNotEquals(12.0, r.perimeter(), 0.000001);
  }

  @Test
  public void testConstructorThrows() {
    assertThrows(IllegalArgumentException.class, () -> new lab3.Rectangle(0, 0, 0, 5));
    assertThrows(IllegalArgumentException.class, () -> new lab3.Rectangle(0, 0, 5, -1));
  }

  @Test
  public void testToString() {
    lab3.Rectangle r = new lab3.Rectangle(0, 0, 3, 4);

    assertTrue(r.toString().contains("Rectangle"));
    assertTrue(r.toString().contains("width"));
  }
}