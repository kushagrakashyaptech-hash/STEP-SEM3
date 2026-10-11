import java.util.*;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double powerWatts();
    abstract String getType();

    double calculateUnits() {
        return powerWatts() * hours / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * 8.0;
    }

    double calculateSaverUnits() {
        return calculateUnits() * SaverMode.SAVER_FACTOR;
    }

    double calculateSaverCost() {
        return calculateSaverUnits() * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) { super(hours); }
    double powerWatts() { return 150.0; }
    String getType() { return "FRIDGE"; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) { super(hours); }
    double powerWatts() { return 1500.0; }
    String getType() { return "AC"; }
}

class Television extends Appliance {
    Television(double hours) { super(hours); }
    double powerWatts() { return 100.0; }
    String getType() { return "TV"; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) { super(hours); }
    double powerWatts() { return 500.0; }
    String getType() { return "WASHER"; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double hours = sc.nextDouble();
            boolean saverRequested = sc.hasNext("SAVER");
            if (saverRequested) {
                sc.next();
            }

            Appliance appliance;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(hours); break;
                case "AC": appliance = new AirConditioner(hours); break;
                case "TV": appliance = new Television(hours); break;
                case "WASHER": appliance = new WashingMachine(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance: " + type);
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;
            double cost;
            if (saverRequested) {
                units = appliance.calculateSaverUnits();
                cost = appliance.calculateSaverCost();
            } else {
                units = appliance.calculateUnits();
                cost = appliance.calculateCost();
            }

            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
            totalCost += cost;
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
