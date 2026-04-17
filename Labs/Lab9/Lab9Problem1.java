import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CS5004 Spring 2026 - Lab 9 Problem 1
 * Smart Home Control System
 *
 * Patterns used:
 * - Singleton: SmartHomeController
 * - Factory Method: DeviceFactory
 * - Adapter: LegacyThermostatAdapter
 * - Facade: SmartHomeFacade
 */
public class Lab9Problem1 {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Smart Home Control System ===");

        // Create devices through the factory
        SmartDevice livingRoomLight = DeviceFactory.createDevice("light", "Living Room Light");
        SmartDevice bedroomLight = DeviceFactory.createDevice("light", "Bedroom Light");
        SmartDevice kitchenSpeaker = DeviceFactory.createDevice("speaker", "Kitchen Speaker");

        // Use the singleton controller
        SmartHomeController controller = SmartHomeController.getInstance();
        controller.addDevice(livingRoomLight);
        controller.addDevice(bedroomLight);
        controller.addDevice(kitchenSpeaker);

        // Use the adapter for a legacy thermostat
        LegacyThermostat legacyThermostat = new LegacyThermostat();
        SmartDevice thermostat = new LegacyThermostatAdapter("Hallway Thermostat", legacyThermostat);
        controller.addDevice(thermostat);

        System.out.println("\nInitial device statuses:");
        controller.printAllStatuses();

        // Turn on a couple of devices manually
        livingRoomLight.turnOn();
        kitchenSpeaker.turnOn();

        System.out.println("\nAfter manually turning on some devices:");
        controller.printAllStatuses();

        // Use the facade for complex actions
        SmartHomeFacade facade = new SmartHomeFacade(controller);

        System.out.println("\nActivating night mode...");
        facade.activateNightMode();
        controller.printAllStatuses();

        System.out.println("\nLeaving home...");
        facade.leaveHome();
        controller.printAllStatuses();
    }
}

interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
    String getName();
}

class SmartLight implements SmartDevice {
    private final String name;
    private boolean on;

    public SmartLight(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    @Override
    public String getStatus() {
        return name + " is " + (on ? "ON" : "OFF");
    }

    @Override
    public String getName() {
        return name;
    }
}

class SmartSpeaker implements SmartDevice {
    private final String name;
    private boolean on;

    public SmartSpeaker(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    @Override
    public String getStatus() {
        return name + " is " + (on ? "ON" : "OFF");
    }

    @Override
    public String getName() {
        return name;
    }
}

// Legacy thermostat with an incompatible interface
class LegacyThermostat {
    private boolean active;
    private int currentTemp;

    public LegacyThermostat() {
        this.active = false;
        this.currentTemp = 68;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public boolean isActive() {
        return active;
    }
}

// Adapter pattern
class LegacyThermostatAdapter implements SmartDevice {
    private final String name;
    private final LegacyThermostat thermostat;

    public LegacyThermostatAdapter(String name, LegacyThermostat thermostat) {
        this.name = name;
        this.thermostat = thermostat;
    }

    @Override
    public void turnOn() {
        thermostat.activate();
    }

    @Override
    public void turnOff() {
        thermostat.deactivate();
    }

    @Override
    public String getStatus() {
        return name + " is " + (thermostat.isActive() ? "ON" : "OFF")
                + " at " + thermostat.getCurrentTemp() + "F";
    }

    @Override
    public String getName() {
        return name;
    }
}

// Factory Method pattern
class DeviceFactory {
    public static SmartDevice createDevice(String type, String name) {
        if (type == null) {
            throw new IllegalArgumentException("Device type cannot be null.");
        }

        switch (type.toLowerCase()) {
            case "light":
                return new SmartLight(name);
            case "speaker":
                return new SmartSpeaker(name);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}

// Singleton pattern
class SmartHomeController {
    private static SmartHomeController instance;
    private final List<SmartDevice> devices;

    private SmartHomeController() {
        this.devices = new ArrayList<>();
    }

    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public List<SmartDevice> getDevices() {
        return Collections.unmodifiableList(devices);
    }

    public void turnAllOn() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnAllOff() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public void printAllStatuses() {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }
}

// Facade pattern
class SmartHomeFacade {
    private final SmartHomeController controller;

    public SmartHomeFacade(SmartHomeController controller) {
        this.controller = controller;
    }

    public void activateNightMode() {
        for (SmartDevice device : controller.getDevices()) {
            if (device instanceof SmartLight) {
                device.turnOff();
            } else {
                device.turnOn();
            }
        }
    }

    public void leaveHome() {
        controller.turnAllOff();
    }
}