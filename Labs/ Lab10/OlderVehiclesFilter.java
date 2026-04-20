import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filters a list of vehicles and returns formatted descriptions of those
 * manufactured before 1999.
 */
public class OlderVehiclesFilter {

  private static final int CUTOFF_YEAR = 1999;

  private List<Vehicle> vehicles = new ArrayList<>();

  /**
   * Constructs an OlderVehiclesFilter from a list of vehicles.
   *
   * @param vehicles the list of {@link Vehicle} objects to filter
   */
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * Constructs an OlderVehiclesFilter from three individual vehicles.
   *
   * @param vehicle1 the first vehicle
   * @param vehicle2 the second vehicle
   * @param vehicle3 the third vehicle
   */
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Returns a formatted description of every vehicle manufactured before 1999.
   *
   * <p>Each entry in the returned list has the format:
   * {@code "make model year"}, for example {@code "Toyota Camry 1995"}.
   * The method uses a functional stream pipeline — filter to select older vehicles,
   * then map to build the description string.</p>
   *
   * @return a {@code List<String>} containing one entry per vehicle whose year
   *         is strictly less than 1999; empty if no such vehicles exist
   */
  public List<String> filterOlderVehilces() {
    return vehicles.stream()
        .filter(v -> v.getYear() < CUTOFF_YEAR)
        .map(v -> v.getMake() + " " + v.getModel() + " " + v.getYear())
        .collect(Collectors.toList());
  }
}
