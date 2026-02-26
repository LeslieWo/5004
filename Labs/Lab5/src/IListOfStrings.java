public interface IListOfStrings {
  boolean isEmpty();
  int size();
  boolean contains(String s);
  boolean containsAll(IListOfStrings other);
  IListOfStrings filterLargerThan(int maxLength);
  boolean hasDuplicates();
  IListOfStrings removeDuplicates();
  void add(String s);
}