package lab3;

public interface Shape extends Comparable<Shape> {

  double area();

  double perimeter();

  lab3.Point2D getReferencePoint();

  double distanceFromOrigin();
}