/**
 * Represents a non-empty node in a recursive list of books.
 * Each ElementNode holds one Book and a reference to the rest of the list.
 */
public class ElementNode implements IListOfBooks {

  private Book book;
  private IListOfBooks rest;

  /**
   * Construct an ElementNode with a book and the rest of the list.
   * @param book the book stored in this node
   * @param rest the remainder of the list
   */
  public ElementNode(Book book, IListOfBooks rest) {
    this.book = book;
    this.rest = rest;
  }

  /**
   * Count this node plus all nodes in the rest of the list.
   * @return total number of books in this list
   */
  @Override
  public int count() {
    return 1 + this.rest.count();
  }

  /**
   * Sum the price of this book with the total price of the rest.
   * @return total price of all books in this list
   */
  @Override
  public float totalPrice() {
    return this.book.getPrice() + this.rest.totalPrice();
  }

  /**
   * If this book was published before the given year, include it in the result.
   * Recurse on the rest of the list either way.
   * @param year the year before which all the returned books are published
   * @return a sublist of books published before the given year
   */
  @Override
  public IListOfBooks allBefore(int year) {
    if (this.book.before(year)) {
      return new ElementNode(this.book, this.rest.allBefore(year));
    } else {
      return this.rest.allBefore(year);
    }
  }

  /**
   * Keep this node at the front, and recurse to add the book at the end of rest.
   * @param book an instance of Class Book
   * @return a new list with the given book appended at the end
   */
  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(this.book, this.rest.addAtEnd(book));
  }

  /**
   * Return this book's info followed by the rest of the list's string.
   * @return a multi-line string of all books in this list
   */
  @Override
  public String toString() {
    return this.book.toString() + "\n" + this.rest.toString();
  }
}