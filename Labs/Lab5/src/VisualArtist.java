public abstract class VisualArtist extends Artist {

  private String[] exhibits;

  public VisualArtist(Name name, int age, String[] genres, String[] awards,
      String[] exhibits) {
    super(name, age, genres, awards);
    this.exhibits = exhibits;
  }

  public String[] getExhibits() { return exhibits; }
}