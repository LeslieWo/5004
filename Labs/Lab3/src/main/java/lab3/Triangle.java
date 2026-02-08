package lab3;

public class Triangle extends lab3.AbstractShape {

  private final lab3.Point2D p1;
  private final lab3.Point2D p2;
  private final lab3.Point2D p3;

  public Triangle(double x1, double y1,
      double x2, double y2,
      double x3, double y3) {

    super(x1, y1); // first point is reference point

    p1 = new lab3.Point2D(x1, y1);
    p2 = new lab3.Point2D(x2, y2);
    p3 = new lab3.Point2D(x3, y3);

    // identical points are not allowed
    if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
      throw new IllegalArgumentException("Triangle cannot have identical points.");
    }
  }

  private double sideA() {
    return p1.distanceTo(p2);
  }

  private double sideB() {
    return p2.distanceTo(p3);
  }

  private double sideC() {
    return p1.distanceTo(p3);
  }

  @Override
  public double perimeter() {
    return sideA() + sideB() + sideC();
  }

  @Override
  public double area() {
    double a = sideA();
    double b = sideB();
    double c = sideC();

    double s = (a + b + c) / 2.0;

    double value = s * (s - a) * (s - b) * (s - c);

    // fix floating-point rounding issues for collinear points
    if (value < 0 && value > -1e-10) {
      value = 0;
    }

    return Math.sqrt(value);
  }

  @Override
  public String toString() {
    return "Triangle: p1=" + p1 + ", p2=" + p2 + ", p3=" + p3;
  }
}