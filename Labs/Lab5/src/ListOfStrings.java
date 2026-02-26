public class ListOfStrings implements IListOfStrings {

  private Node head;

  public ListOfStrings() {
    this.head = null;
  }

  @Override
  public void add(String s) {
    Node newNode = new Node(s);
    if (head == null) {
      head = newNode;
    } else {
      Node cur = head;
      while (cur.next != null) cur = cur.next;
      cur.next = newNode;
    }
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public int size() {
    int count = 0;
    Node cur = head;
    while (cur != null) {
      count++;
      cur = cur.next;
    }
    return count;
  }

  @Override
  public boolean contains(String s) {
    Node cur = head;
    while (cur != null) {
      if (cur.data.equals(s)) return true;
      cur = cur.next;
    }
    return false;
  }

  @Override
  public boolean containsAll(IListOfStrings other) {
    if (!(other instanceof ListOfStrings)) return false;
    Node cur = ((ListOfStrings) other).head;
    while (cur != null) {
      if (!this.contains(cur.data)) return false;
      cur = cur.next;
    }
    return true;
  }

  @Override
  public IListOfStrings filterLargerThan(int maxLength) {
    ListOfStrings result = new ListOfStrings();
    Node cur = head;
    while (cur != null) {
      if (cur.data.length() <= maxLength) {
        result.add(cur.data);
      }
      cur = cur.next;
    }
    return result;
  }

  @Override
  public boolean hasDuplicates() {
    Node outer = head;
    while (outer != null) {
      Node inner = outer.next;
      while (inner != null) {
        if (outer.data.equals(inner.data)) return true;
        inner = inner.next;
      }
      outer = outer.next;
    }
    return false;
  }

  @Override
  public IListOfStrings removeDuplicates() {
    ListOfStrings result = new ListOfStrings();
    Node cur = head;
    while (cur != null) {
      if (!result.contains(cur.data)) {
        result.add(cur.data);
      }
      cur = cur.next;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node cur = head;
    while (cur != null) {
      sb.append(cur.data);
      if (cur.next != null) sb.append(", ");
      cur = cur.next;
    }
    sb.append("]");
    return sb.toString();
  }
}