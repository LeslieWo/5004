package lab3;

import java.util.Objects;

public class Point2D {

  private final double x;
  private final double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double distanceTo(Point2D other) {
    double dx = x - other.x;
    double dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double distanceFromOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Point2D)) {
      return false;
    }

    Point2D other = (Point2D) obj;
    return Double.compare(this.x, other.x) == 0
        && Double.compare(this.y, other.y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}