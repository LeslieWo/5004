public class Musician extends Artist {

  private String recordingCompany;
  private String lastRecordAlbum;

  public Musician(Name name, int age, String[] genres, String[] awards,
      String recordingCompany, String lastRecordAlbum) {
    super(name, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum  = lastRecordAlbum;
  }

  public String getRecordingCompany() { return recordingCompany; }
  public String getLastRecordAlbum()  { return lastRecordAlbum; }
}