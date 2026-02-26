public class Poet extends Artist {

  private String publishingCompany;
  private String lastPublishedCollection;

  public Poet(Name name, int age, String[] genres, String[] awards,
      String publishingCompany, String lastPublishedCollection) {
    super(name, age, genres, awards);
    this.publishingCompany       = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public String getPublishingCompany()       { return publishingCompany; }
  public String getLastPublishedCollection() { return lastPublishedCollection; }
}