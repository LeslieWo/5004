import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {

  private IListOfBooks empty;
  private IListOfBooks oneBook;
  private IListOfBooks threeBooks;
  private Book b1, b2, b3;

  @BeforeEach
  public void setUp() {
    empty = new EmptyNode();
    b1 = new Book("Clean Code", "Robert Martin", 2008, 35.99f);
    b2 = new Book("Effective Java", "Joshua Bloch", 2018, 45.00f);
    b3 = new Book("SICP", "Abelson", 1996, 20.00f);

    oneBook = new ElementNode(b1, new EmptyNode());
    threeBooks = new ElementNode(b1,
        new ElementNode(b2,
            new ElementNode(b3, new EmptyNode())));
  }

  // ── EmptyNode: count ──────────────────────────────────────────────
  @Test
  public void testEmptyCount() {
    assertEquals(0, empty.count());
  }

  @Test
  public void testEmptyCountAfterAllBefore() {
    assertEquals(0, empty.allBefore(2000).count());
  }

  // ── EmptyNode: totalPrice ─────────────────────────────────────────
  @Test
  public void testEmptyTotalPrice() {
    assertEquals(0.0f, empty.totalPrice(), 0.001f);
  }

  @Test
  public void testEmptyTotalPriceIsZeroNotNegative() {
    assertTrue(empty.totalPrice() >= 0);
  }

  // ── EmptyNode: allBefore ──────────────────────────────────────────
  @Test
  public void testEmptyAllBeforeReturnsEmpty() {
    assertEquals(0, empty.allBefore(2000).count());
  }

  @Test
  public void testEmptyAllBeforeAnyYear() {
    assertEquals(0, empty.allBefore(1).count());
  }

  // ── EmptyNode: addAtEnd ───────────────────────────────────────────
  @Test
  public void testEmptyAddAtEndCountBecomesOne() {
    assertEquals(1, empty.addAtEnd(b1).count());
  }

  @Test
  public void testEmptyAddAtEndPriceCorrect() {
    assertEquals(b1.getPrice(), empty.addAtEnd(b1).totalPrice(), 0.001f);
  }

  // ── EmptyNode: toString ───────────────────────────────────────────
  @Test
  public void testEmptyToStringIsEmpty() {
    assertEquals("", empty.toString());
  }

  @Test
  public void testEmptyToStringNotNull() {
    assertNotNull(empty.toString());
  }

  // ── ElementNode: count ────────────────────────────────────────────
  @Test
  public void testElementCountOne() {
    assertEquals(1, oneBook.count());
  }

  @Test
  public void testElementCountThree() {
    assertEquals(3, threeBooks.count());
  }

  // ── ElementNode: totalPrice ───────────────────────────────────────
  @Test
  public void testElementTotalPriceOne() {
    assertEquals(35.99f, oneBook.totalPrice(), 0.001f);
  }

  @Test
  public void testElementTotalPriceThree() {
    assertEquals(35.99f + 45.00f + 20.00f, threeBooks.totalPrice(), 0.001f);
  }

  // ── ElementNode: allBefore ────────────────────────────────────────
  @Test
  public void testAllBeforeNoneQualify() {
    // all books are from 1996 or later; year 1990 → 0 results
    assertEquals(0, threeBooks.allBefore(1990).count());
  }

  @Test
  public void testAllBeforeSomeQualify() {
    // b3 (1996) and b1 (2008) are before 2010; b2 (2018) is not
    assertEquals(2, threeBooks.allBefore(2010).count());
  }

  // ── ElementNode: addAtEnd ─────────────────────────────────────────
  @Test
  public void testAddAtEndIncreasesCount() {
    assertEquals(4, threeBooks.addAtEnd(b1).count());
  }

  @Test
  public void testAddAtEndPriceIncreases() {
    float before = threeBooks.totalPrice();
    float after  = threeBooks.addAtEnd(b2).totalPrice();
    assertEquals(before + b2.getPrice(), after, 0.001f);
  }

  // ── ElementNode: toString ─────────────────────────────────────────
  @Test
  public void testElementToStringContainsTitle() {
    assertTrue(oneBook.toString().contains("Clean Code"));
  }

  @Test
  public void testElementToStringAllBooks() {
    String s = threeBooks.toString();
    assertTrue(s.contains("Clean Code") && s.contains("Effective Java") && s.contains("SICP"));
  }
}