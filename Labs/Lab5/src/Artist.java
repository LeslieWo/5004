import java.util.Arrays;

public abstract class Artist {

  private Name name;
  private int age;
  private String[] genres;
  private String[] awards;

  public Artist(Name name, int age, String[] genres, String[] awards) {
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Age must be between 0 and 128.");
    }
    this.name   = name;
    this.age    = age;
    this.genres = genres;
    this.awards = awards;
  }

  public void receiveAward(String award) {
    String[] newAwards = Arrays.copyOf(this.awards, this.awards.length + 1);
    newAwards[this.awards.length] = award;
    this.awards = newAwards;
  }

  public Name getName()       { return name; }
  public int getAge()         { return age; }
  public String[] getGenres() { return genres; }
  public String[] getAwards() { return awards; }

  @Override
  public String toString() {
    return "Artist{name=" + name + ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) + "}";
  }
}
