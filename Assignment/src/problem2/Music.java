package problem2;

/**
 * Represents music in the library collection.
 */
public class Music extends Item {

    /**
     * Constructor for Music
     * @param creator the music's creator (RecordingArtist or Band)
     * @param title the music's title
     * @param year the year the music was released
     */
    public Music(Creator creator, String title, int year) {
        super(creator, title, year);
    }
}