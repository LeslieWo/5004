package problem2;

/**
 * Represents a book in the library collection.
 */
public class Book extends Item {

    /**
     * Constructor for Book
     * @param author the book's author
     * @param title the book's title
     * @param year the year the book was published
     */
    public Book(Author author, String title, int year) {
        super(author, title, year);
    }

    /**
     * Gets the author (overridden for type specificity)
     * @return the author
     */
    public Author getAuthor() {
        return (Author) getCreator();
    }
}
