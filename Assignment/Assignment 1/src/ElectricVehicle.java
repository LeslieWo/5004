/**
 * Represents an electric vehicle and provides methods to compute range
 * and update efficiency based on temperature.
 */
public class ElectricVehicle {

  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;

  /**
   * Constructs an ElectricVehicle with the given parameters.
   *
   * @param name the name of the vehicle
   * @param batterySize the battery size in kWh
   * @param stateOfCharge the state of charge (decimal 0.15 - 1.0)
   * @param defaultEfficiency the rated efficiency
   */
  public ElectricVehicle(String name,
      double batterySize,
      double stateOfCharge,
      double defaultEfficiency) {

    if (name == null || name.isEmpty()) {
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

    this.batterySize = clamp(batterySize, 10.0, 150.0);
    this.stateOfCharge = clamp(stateOfCharge, 0.15, 1.0);
    this.defaultEfficiency = clamp(defaultEfficiency, 0.5, 4.5);
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * Returns the driving range of the EV.
   *
   * @return range in miles
   */
  public double range() {
    return currentEfficiency * stateOfCharge * batterySize;
  }

  /**
   * Updates the current efficiency based on temperature in Fahrenheit.
   *
   * @param currentTemp the current temperature
   */
  public void updateEfficiency(double currentTemp) {
    if (currentTemp >= 65.0 && currentTemp <= 77.0) {
      currentEfficiency = defaultEfficiency;
    } else if (currentTemp > 77.0) {
      currentEfficiency = defaultEfficiency * 0.85;
    } else {
      double reduction = (65.0 - currentTemp) * 0.01;
      double factor = 1.0 - reduction;
      if (factor < 0.5) {
        factor = 0.5;
      }
      currentEfficiency = defaultEfficiency * factor;
    }
  }

  /**
   * Returns the current efficiency.
   *
   * @return current efficiency
   */
  public double getEfficiency() {
    return currentEfficiency;
  }

  /**
   * Returns the battery size.
   *
   * @return battery size
   */
  public double getBatterySize() {
    return batterySize;
  }

  /**
   * Returns the state of charge (decimal form).
   *
   * @return state of charge
   */
  public double getStateOfCharge() {
    return stateOfCharge;
  }

  /**
   * Returns the name of the EV.
   *
   * @return vehicle name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets a new state of charge (clamped).
   *
   * @param stateOfCharge new state of charge
   */
  public void setStateOfCharge(double stateOfCharge) {
    this.stateOfCharge = clamp(stateOfCharge, 0.15, 1.0);
  }

  /**
   * Returns a formatted string representation of the EV.
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return String.format(
        "%s SOC: %.1f%% Range (miles): %.1f",
        name,
        stateOfCharge * 100.0,
        range()
    );
  }

  private double clamp(double value, double min, double max) {
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }
}
