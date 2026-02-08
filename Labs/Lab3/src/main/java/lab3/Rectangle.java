package lab3;

public class Rectangle extends lab3.AbstractShape {

  private final double width;
  private final double height;

  public Rectangle(double x, double y, double width, double height) {
    super(x, y);

    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive.");
    }

    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public double perimeter() {
    return 2 * (width + height);
  }

  @Override
  public double area() {
    return width * height;
  }

  @Override
  public String toString() {
    return "Rectangle: ref=" + getReferencePoint() + ", width=" + width + ", height=" + height;
  }
}