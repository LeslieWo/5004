/**
 * Represents a Shoe with kind, color, brand, and size.
 */
public class Shoe {

  private Kind kind;
  private Color color;
  private Brand brand;
  private double size;

  /**
   * Creates a Shoe with the given attributes.
   *
   * @param kind the type of shoe
   * @param color the color of the shoe
   * @param brand the brand of the shoe
   * @param size the shoe size
   * @throws IllegalArgumentException if brand is NIKE and kind is DRESS
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("NIKE does not sell dress shoes");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  public Kind getKind() {
    return kind;
  }

  public Color getColor() {
    return color;
  }

  public Brand getBrand() {
    return brand;
  }

  public double getSize() {
    return size;
  }

  @Override
  public String toString() {
    String kindStr;
    switch (kind) {
      case DRESS:
        kindStr = "Dress";
        break;
      case SNEAKER:
        kindStr = "Sneaker";
        break;
      default:
        kindStr = "Casual";
    }

    String colorStr;
    switch (color) {
      case BLACK:
        colorStr = "Black";
        break;
      case WHITE:
        colorStr = "White";
        break;
      default:
        colorStr = "Neutral";
    }

    return brand + " " + colorStr + " " + kindStr + " size " + size;
  }
}

