package lab3;

public class Circle extends lab3.AbstractShape {

  private final double radius;

  public Circle(double x, double y, double radius) {
    super(x, y);

    if (radius <= 0) {
      throw new IllegalArgumentException("Radius must be positive.");
    }

    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return "Circle: center=" + getReferencePoint() + ", radius=" + radius;
  }
}