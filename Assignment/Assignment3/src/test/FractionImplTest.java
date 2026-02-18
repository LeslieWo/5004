import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionImplTest {

  @Test
  void constructorNormalizesSigns() {
    Fraction f = new FractionImpl(-2, 4);
    assertEquals(-1, f.getNumerator());
    assertEquals(2, f.getDenominator());
  }

  @Test
  void constructorThrowsIfDenominatorNonPositive() {
    assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(1, 0));
    assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(1, -2));
  }

  @Test
  void zeroNumeratorHandled() {
    Fraction f = new FractionImpl(0, 5);
    assertEquals(0, f.getNumerator());
    assertEquals(1, f.getDenominator());
  }

  @Test
  void toDoubleWorks() {
    Fraction f = new FractionImpl(1, 4);
    assertEquals(0.25, f.toDouble(), 1e-9);
  }

  @Test
  void reciprocalTypical() {
    Fraction f = new FractionImpl(2, 3);
    Fraction r = f.reciprocal();
    assertEquals(3, r.getNumerator());
    assertEquals(2, r.getDenominator());
  }

  @Test
  void reciprocalZeroThrows() {
    Fraction f = new FractionImpl(0, 1);
    assertThrows(ArithmeticException.class, f::reciprocal);
  }

  @Test
  void addSameDenominator() {
    Fraction a = new FractionImpl(1, 4);
    Fraction b = new FractionImpl(2, 4);
    Fraction result = a.add(b);
    assertEquals("3 / 4", result.toString());
  }

  @Test
  void addDifferentDenominator() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(1, 3);
    Fraction result = a.add(b);
    assertEquals("5 / 6", result.toString());
  }

  @Test
  void addWithNegatives() {
    Fraction a = new FractionImpl(-1, 2);
    Fraction b = new FractionImpl(1, 2);
    Fraction result = a.add(b);
    assertEquals("0 / 1", result.toString());
  }

  @Test
  void compareLessGreaterEqual() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(3, 4);
    Fraction c = new FractionImpl(2, 4);

    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
    assertEquals(0, a.compareTo(c));
  }
}
