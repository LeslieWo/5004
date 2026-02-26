public abstract class MultimediaArtist extends Artist {

  private String[] movies;
  private String[] series;
  private String[] otherMultimedia;

  public MultimediaArtist(Name name, int age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] otherMultimedia) {
    super(name, age, genres, awards);
    this.movies          = movies;
    this.series          = series;
    this.otherMultimedia = otherMultimedia;
  }

  public String[] getMovies()          { return movies; }
  public String[] getSeries()          { return series; }
  public String[] getOtherMultimedia() { return otherMultimedia; }
}