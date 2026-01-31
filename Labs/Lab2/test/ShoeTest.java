// NOTE: Test cases written using JUnit 5 syntax, but test execution failed due to unresolved dependencies (JUnit jars not linked successfully in IntelliJ).

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Shoe class.
 */
public class ShoeTest {

  @Test
  public void testConstructorAndGetters() {
    Shoe shoe = new Shoe(
        Kind.SNEAKER,
        Color.BLACK,
        Brand.NIKE,
        9.5
    );

    assertEquals(Kind.SNEAKER, shoe.getKind());
    assertEquals(Color.BLACK, shoe.getColor());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(9.5, shoe.getSize(), 0.001);
  }

  @Test
  public void testInvalidNikeDress() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.BLACK, Brand.NIKE, 8.0)
    );
  }

  @Test
  public void testToString() {
    Shoe shoe = new Shoe(
        Kind.BOOT,
        Color.BROWN,
        Brand.CLARKS,
        10.0
    );

    String result = shoe.toString();

    assertTrue(result.contains("CLARKS"));
    assertTrue(result.contains("10"));
  }
}
