package lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

  @Test
  public void testArea() {
    lab3.Circle c = new lab3.Circle(0, 0, 2);

    assertEquals(Math.PI * 4, c.area(), 0.000001);
    assertNotEquals(10.0, c.area(), 0.000001);
  }

  @Test
  public void testPerimeter() {
    lab3.Circle c = new lab3.Circle(0, 0, 2);

    assertEquals(2 * Math.PI * 2, c.perimeter(), 0.000001);
    assertNotEquals(12.0, c.perimeter(), 0.000001);
  }

  @Test
  public void testConstructorThrows() {
    assertThrows(IllegalArgumentException.class, () -> new lab3.Circle(0, 0, 0));
    assertThrows(IllegalArgumentException.class, () -> new lab3.Circle(0, 0, -2));
  }

  @Test
  public void testToString() {
    lab3.Circle c = new lab3.Circle(0, 0, 2);

    assertTrue(c.toString().contains("Circle"));
    assertTrue(c.toString().contains("radius"));
  }
}