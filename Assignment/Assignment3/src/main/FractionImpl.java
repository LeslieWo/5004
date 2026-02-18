/**
 * Concrete implementation of the Fraction interface.
 *
 * <p>This class maintains the invariant:
 * <ul>
 *   <li>Denominator always positive</li>
 *   <li>Stored in simplest form</li>
 *   <li>Sign stored in numerator</li>
 * </ul>
 */
public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a FractionImpl with the given numerator and denominator.
   *
   * @param numerator integer numerator
   * @param denominator integer denominator (must be > 0)
   * @throws IllegalArgumentException if denominator <= 0
   */
  public FractionImpl(int numerator, int denominator) {
    validateDenominator(denominator);
    this.numerator = numerator;
    this.denominator = denominator;
    normalize(); // centralize invariant enforcement
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    this.numerator = n;
    normalize();
  }

  @Override
  public void setDenominator(int d) {
    validateDenominator(d);
    this.denominator = d;
    normalize();
  }

  private void validateDenominator(int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
  }

  /**
   * Normalizes the fraction:
   * 1. Ensures denominator positive
   * 2. Moves sign to numerator
   * 3. Reduces to simplest form using gcd
   */
  private void normalize() {
    if (denominator < 0) {
      denominator = -denominator;
      numerator = -numerator;
    }

    if (numerator == 0) {
      denominator = 1;
      return;
    }

    int gcd = gcd(Math.abs(numerator), denominator);
    numerator /= gcd;
    denominator /= gcd;
  }

  /**
   * Euclid's algorithm for greatest common divisor.
   */
  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new ArithmeticException("Cannot take reciprocal of zero.");
    }
    return new FractionImpl(denominator, numerator);
  }

  @Override
  public Fraction add(Fraction other) {
    int newNumerator =
        this.numerator * other.getDenominator()
            + other.getNumerator() * this.denominator;

    int newDenominator =
        this.denominator * other.getDenominator();

    return new FractionImpl(newNumerator, newDenominator);
  }

  @Override
  public int compareTo(Fraction other) {
    long left = (long) this.numerator * other.getDenominator();
    long right = (long) other.getNumerator() * this.denominator;
    return Long.compare(left, right);
  }

  /**
   * Returns a string representation in simplest form.
   *
   * @return string like "3 / 4"
   */
  @Override
  public String toString() {
    return numerator + " / " + denominator;
  }
}
