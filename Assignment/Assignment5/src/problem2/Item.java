package problem2;

/**
 * Abstract class representing an item in the library collection.
 */
public abstract class Item {
    private Creator creator;
    private String title;
    private int year;

    /**
     * Constructor for Item
     * @param creator the item's creator
     * @param title the item's title
     * @param year the year the item was released/published
     */
    public Item(Creator creator, String title, int year) {
        this.creator = creator;
        this.title = title;
        this.year = year;
    }

    /**
     * Gets the creator
     * @return the creator
     */
    public Creator getCreator() {
        return creator;
    }

    /**
     * Gets the title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the year
     * @return the year
     */
    public int getYear() {
        return year;
    }
}
