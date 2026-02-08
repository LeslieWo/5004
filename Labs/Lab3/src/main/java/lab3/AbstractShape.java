package lab3;

public abstract class AbstractShape implements lab3.Shape {

  private final lab3.Point2D referencePoint;

  public AbstractShape(double x, double y) {
    this.referencePoint = new lab3.Point2D(x, y);
  }

  @Override
  public lab3.Point2D getReferencePoint() {
    return referencePoint;
  }

  @Override
  public double distanceFromOrigin() {
    return referencePoint.distanceFromOrigin();
  }

  @Override
  public int compareTo(lab3.Shape other) {
    return Double.compare(this.distanceFromOrigin(), other.distanceFromOrigin());
  }
}