import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class for identifying trending topics on social media by counting
 * how many times each topic appears in a list of strings.
 */
public class TrendingTopics {

  /**
   * Counts the number of occurrences of each topic in the given list.
   *
   * <p>Uses a stream with {@code Collectors.groupingBy} and
   * {@code Collectors.counting()} to build the frequency map in a
   * single functional pipeline — no explicit loops required.</p>
   *
   * @param topics a {@code List<String>} of topic strings (may contain duplicates)
   * @return a {@code Map<String, Long>} where each key is a distinct topic and
   *         the value is the number of times it appears in {@code topics}
   */
  public Map<String, Long> countTopics(List<String> topics) {
    return topics.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
