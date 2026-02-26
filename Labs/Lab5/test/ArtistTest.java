import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

  private Musician musician;
  private Actor actor;
  private Poet poet;

  @BeforeEach
  void setUp() {
    musician = new Musician(
        new Name("Taylor", "Swift"),
        34,
        new String[]{"Pop", "Country"},
        new String[]{"Grammy"},
        "Republic Records",
        "The Tortured Poets Department"
    );

    actor = new Actor(
        new Name("Tom", "Hanks"),
        67,
        new String[]{"Drama"},
        new String[]{"Oscar"},
        new String[]{"Forrest Gump", "Cast Away"},
        new String[]{"Band of Brothers"},
        new String[]{}
    );

    poet = new Poet(
        new Name("Maya", "Angelou"),
        86,
        new String[]{"Poetry"},
        new String[]{},
        "Random House",
        "I Know Why the Caged Bird Sings"
    );
  }

  @Test
  void testMusicianFields() {
    assertEquals("Taylor", musician.getName().getFirstName());
    assertEquals("Swift", musician.getName().getLastName());
    assertEquals(34, musician.getAge());
    assertEquals("Republic Records", musician.getRecordingCompany());
    assertEquals("The Tortured Poets Department", musician.getLastRecordAlbum());
  }

  @Test
  void testReceiveAward() {
    musician.receiveAward("MTV Award");
    assertEquals(2, musician.getAwards().length);
    assertEquals("MTV Award", musician.getAwards()[1]);
  }

  @Test
  void testActorMovies() {
    assertEquals(2, actor.getMovies().length);
    assertEquals("Forrest Gump", actor.getMovies()[0]);
  }

  @Test
  void testPoetFields() {
    assertEquals("Random House", poet.getPublishingCompany());
    assertEquals("I Know Why the Caged Bird Sings", poet.getLastPublishedCollection());
  }

  @Test
  void testInvalidAge() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Musician(new Name("Bad", "Age"), 200,
          new String[]{}, new String[]{}, "Label", "Album");
    });
  }
}