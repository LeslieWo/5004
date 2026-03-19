package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a band (group of recording artists).
 */
public class Band implements Creator {
    private String name;
    private List<RecordingArtist> members;

    /**
     * Constructor for Band
     * @param name the band's name
     */
    public Band(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    /**
     * Gets the band name
     * @return the band name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a member to the band
     * @param artist the recording artist to add
     */
    public void addMember(RecordingArtist artist) {
        members.add(artist);
    }

    /**
     * Gets all band members
     * @return a copy of the members list
     */
    public List<RecordingArtist> getMembers() {
        return new ArrayList<>(members);
    }

    /**
     * Checks if a given artist is a member of this band
     * @param artist the artist to check
     * @return true if the artist is a member, false otherwise
     */
    public boolean hasMember(RecordingArtist artist) {
        return members.contains(artist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return Objects.equals(name, band.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
