import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListOfStringsTest {

  private ListOfStrings list;

  @BeforeEach
  void setUp() {
    list = new ListOfStrings();
    list.add("apple");
    list.add("banana");
    list.add("kiwi");
    list.add("apple"); // 故意重复
  }

  @Test
  void testIsEmpty() {
    assertFalse(list.isEmpty());
    ListOfStrings empty = new ListOfStrings();
    assertTrue(empty.isEmpty());
  }

  @Test
  void testSize() {
    assertEquals(4, list.size());
  }

  @Test
  void testContains() {
    assertTrue(list.contains("banana"));
    assertFalse(list.contains("mango"));
  }

  @Test
  void testContainsAll() {
    ListOfStrings other = new ListOfStrings();
    other.add("apple");
    other.add("kiwi");
    assertTrue(list.containsAll(other));

    other.add("mango");
    assertFalse(list.containsAll(other));
  }

  @Test
  void testFilterLargerThan() {
    // 保留长度 <= 4 的，只有 "kiwi"
    IListOfStrings filtered = list.filterLargerThan(4);
    assertEquals(1, filtered.size());
    assertTrue(filtered.contains("kiwi"));
    assertFalse(filtered.contains("apple"));
  }

  @Test
  void testHasDuplicates() {
    assertTrue(list.hasDuplicates());

    ListOfStrings noDup = new ListOfStrings();
    noDup.add("cat");
    noDup.add("dog");
    assertFalse(noDup.hasDuplicates());
  }

  @Test
  void testRemoveDuplicates() {
    IListOfStrings result = list.removeDuplicates();
    assertEquals(3, result.size()); // apple, banana, kiwi
    assertFalse(result.hasDuplicates());
  }
}