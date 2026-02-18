/**
 * Represents an empty list of books (the base case of the recursive structure).
 */
public class EmptyNode implements IListOfBooks {

  /**
   * An empty list has no books, so count returns 0.
   * @return 0
   */
  @Override
  public int count() {
    return 0;
  }

  /**
   * An empty list has no books, so total price is 0.
   * @return 0.0f
   */
  @Override
  public float totalPrice() {
    return 0.0f;
  }

  /**
   * An empty list has no books before any year, so return a new EmptyNode.
   * @param year the year before which all the returned books are published
   * @return an empty list
   */
  @Override
  public IListOfBooks allBefore(int year) {
    return new EmptyNode();
  }

  /**
   * Adding a book at the end of an empty list creates a single-element list.
   * @param book an instance of Class Book
   * @return a new ElementNode containing only this book
   */
  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(book, new EmptyNode());
  }

  /**
   * String representation of an empty list.
   * @return an empty string
   */
  @Override
  public String toString() {
    return "";
  }
}