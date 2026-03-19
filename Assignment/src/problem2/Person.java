package problem2;

import java.util.Objects;

/**
 * Abstract class representing an individual person (Author or RecordingArtist).
 */
public abstract class Person implements Creator {
    private String firstName;
    private String lastName;

    /**
     * Constructor for Person
     * @param firstName the person's first name
     * @param lastName the person's last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the full name
     * @return the full name (first + last)
     */
    @Override
    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
               Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}