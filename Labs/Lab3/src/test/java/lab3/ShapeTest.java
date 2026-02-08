package lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

  private static class DummyShape extends lab3.AbstractShape {

    public DummyShape(double x, double y) {
      super(x, y);
    }

    @Override
    public double area() {
      return 0;
    }

    @Override
    public double perimeter() {
      return 0;
    }

    @Override
    public String toString() {
      return "DummyShape";
    }
  }

  @Test
  public void testCompareToLessThan() {
    lab3.Shape s1 = new DummyShape(1, 1);
    lab3.Shape s2 = new DummyShape(5, 5);

    assertTrue(s1.compareTo(s2) < 0);
    assertFalse(s1.compareTo(s2) > 0);
  }

  @Test
  public void testCompareToGreaterThan() {
    lab3.Shape s1 = new DummyShape(10, 10);
    lab3.Shape s2 = new DummyShape(1, 1);

    assertTrue(s1.compareTo(s2) > 0);
    assertFalse(s1.compareTo(s2) < 0);
  }

  @Test
  public void testCompareToEqual() {
    lab3.Shape s1 = new DummyShape(3, 4);
    lab3.Shape s2 = new DummyShape(3, 4);

    assertEquals(0, s1.compareTo(s2));
    assertTrue(s1.compareTo(s2) == 0);
  }

  @Test
  public void testDistanceFromOrigin() {
    lab3.Shape s = new DummyShape(3, 4);

    assertEquals(5.0, s.distanceFromOrigin(), 0.000001);
    assertNotEquals(6.0, s.distanceFromOrigin(), 0.000001);
  }

  @Test
  public void testReferencePoint() {
    lab3.Shape s = new DummyShape(2, 7);

    assertEquals(2.0, s.getReferencePoint().getX(), 0.000001);
    assertEquals(7.0, s.getReferencePoint().getY(), 0.000001);
  }
}