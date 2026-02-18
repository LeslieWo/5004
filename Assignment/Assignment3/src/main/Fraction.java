/**
 * Represents an immutable mathematical fraction with an integer numerator
 * and a strictly positive integer denominator.
 *
 * <p>Implementations must guarantee:
 * <ul>
 *   <li>Denominator is always positive</li>
 *   <li>Fraction is stored in simplest form</li>
 *   <li>If negative, the numerator carries the sign</li>
 * </ul>
 *
 * <p>This interface extends Comparable to allow ordering of fractions.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of this fraction.
   *
   * @return integer numerator
   */
  int getNumerator();

  /**
   * Returns the denominator of this fraction.
   *
   * @return positive integer denominator
   */
  int getDenominator();

  /**
   * Sets the numerator of this fraction.
   * Implementations must preserve normalization and invariants.
   *
   * @param n new numerator
   */
  void setNumerator(int n);

  /**
   * Sets the denominator of this fraction.
   * Denominator must remain strictly positive.
   *
   * @param d new denominator
   * @throws IllegalArgumentException if d <= 0
   */
  void setDenominator(int d);

  /**
   * Returns the decimal (scientific) value of this fraction.
   *
   * @return double representation
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction.
   *
   * @return new Fraction representing 1 / this
   * @throws ArithmeticException if numerator is zero
   */
  Fraction reciprocal();

  /**
   * Adds another fraction to this fraction.
   *
   * @param other fraction to add
   * @return new Fraction representing the sum
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction with another fraction.
   *
   * @param other fraction to compare against
   * @return negative if this < other,
   *         positive if this > other,
   *         zero if equal
   */
  @Override
  int compareTo(Fraction other);
}
