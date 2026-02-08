import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ElectricVehicle class.
 */
public class ElectricVehicleTest {

  /**
   * Tests constructor clamping and initialization.
   */
  @Test
  public void testConstructorClamping() {
    ElectricVehicle ev = new ElectricVehicle(null, 200.0, 2.0, 10.0);

    assertEquals("unknown EV", ev.getName());
    assertEquals(150.0, ev.getBatterySize());
    assertEquals(1.0, ev.getStateOfCharge());
    assertEquals(4.5, ev.getEfficiency());
  }

  /**
   * Tests lower bound clamping in constructor.
   */
  @Test
  public void testConstructorLowerBounds() {
    ElectricVehicle ev = new ElectricVehicle("", 1.0, 0.0, 0.0);

    assertEquals("unknown EV", ev.getName());
    assertEquals(10.0, ev.getBatterySize());
    assertEquals(0.15, ev.getStateOfCharge());
    assertEquals(0.5, ev.getEfficiency());
  }

  /**
   * Tests range calculation.
   */
  @Test
  public void testRangeCalculation() {
    ElectricVehicle ev = new ElectricVehicle("Test EV", 50.0, 0.5, 4.0);
    assertEquals(100.0, ev.range());
  }

  /**
   * Tests efficiency at optimal temperature.
   */
  @Test
  public void testUpdateEfficiencyOptimal() {
    ElectricVehicle ev = new ElectricVehicle("EV", 50, 0.5, 4.0);

    ev.updateEfficiency(70.0);
    assertEquals(4.0, ev.getEfficiency());
  }

  /**
   * Tests efficiency at high temperature.
   */
  @Test
  public void testUpdateEfficiencyHot() {
    ElectricVehicle ev = new ElectricVehicle("EV", 50, 0.5, 4.0);

    ev.updateEfficiency(80.0);
    assertEquals(3.4, ev.getEfficiency());
  }

  /**
   * Tests efficiency reduction below 65F.
   */
  @Test
  public void testUpdateEfficiencyCold() {
    ElectricVehicle ev = new ElectricVehicle("EV", 50, 0.5, 4.0);

    ev.updateEfficiency(64.0);
    assertEquals(3.96, ev.getEfficiency(), 0.0001);
  }

  /**
   * Tests cold efficiency clamping at 50%.
   */
  @Test
  public void testUpdateEfficiencyColdMinimum() {
    ElectricVehicle ev = new ElectricVehicle("EV", 50, 0.5, 4.0);

    ev.updateEfficiency(0.0);
    assertEquals(2.0, ev.getEfficiency());
  }

  /**
   * Tests setStateOfCharge clamping.
   */
  @Test
  public void testSetStateOfCharge() {
    ElectricVehicle ev = new ElectricVehicle("EV", 50, 0.5, 4.0);

    ev.setStateOfCharge(2.0);
    assertEquals(1.0, ev.getStateOfCharge());

    ev.setStateOfCharge(0.0);
    assertEquals(0.15, ev.getStateOfCharge());
  }

  /**
   * Tests toString formatting.
   */
  @Test
  public void testToStringFormat() {
    ElectricVehicle ev = new ElectricVehicle("Ford MachE", 50.0, 0.5, 4.0);

    String expected = "Ford MachE SOC: 50.0% Range (miles): 100.0";
    assertEquals(expected, ev.toString());
  }
}
