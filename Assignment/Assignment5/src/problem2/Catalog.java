package problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a catalog of library items with search functionality.
 */
public class Catalog {
    private List<Item> items;

    /**
     * Constructor for Catalog with initial items
     * @param items the initial collection of items
     */
    public Catalog(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    /**
     * Constructor for empty Catalog
     */
    public Catalog() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the catalog
     * @param item the item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the catalog
     * @param item the item to remove
     * @return true if the item was removed, false otherwise
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Searches for items by keyword in title (case-insensitive).
     * @param keyword the keyword to search for
     * @return a list of items with titles containing the keyword
     */
    public List<Item> search(String keyword) {
        List<Item> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        
        for (Item item : items) {
            if (item.getTitle().toLowerCase().contains(lowerKeyword)) {
                results.add(item);
            }
        }
        
        return results;
    }

    /**
     * Searches for items by author (exact match).
     * @param author the author to search for
     * @return a list of books by the specified author
     */
    public List<Item> search(Author author) {
        List<Item> results = new ArrayList<>();
        
        for (Item item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getAuthor().equals(author)) {
                    results.add(item);
                }
            }
        }
        
        return results;
    }

    /**
     * Searches for items by recording artist (exact match).
     * The artist may be a solo artist or a band member.
     * @param artist the recording artist to search for
     * @return a list of music by the specified artist
     */
    public List<Item> search(RecordingArtist artist) {
        List<Item> results = new ArrayList<>();
        
        for (Item item : items) {
            if (item instanceof Music) {
                Creator creator = item.getCreator();
                
                // Check if creator is the artist directly
                if (creator.equals(artist)) {
                    results.add(item);
                }
                // Check if creator is a band containing the artist
                else if (creator instanceof Band) {
                    Band band = (Band) creator;
                    if (band.hasMember(artist)) {
                        results.add(item);
                    }
                }
            }
        }
        
        return results;
    }
}
