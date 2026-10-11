import java.util.*;

interface NightService {
    double NIGHT_SURCHARGE = 0.20;
}

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double ratePerKm();
    abstract String getType();

    double calculateFare() {
        return Math.max(km * ratePerKm(), 100.0);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) { super(km); }
    double ratePerKm() { return 10.0; }
    String getType() { return "MINI"; }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) { super(km); }
    double ratePerKm() { return 14.0; }
    String getType() { return "SEDAN"; }

    double calculateNightFare() {
        return calculateFare() * (1.0 + NIGHT_SURCHARGE);
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) { super(km); }
    double ratePerKm() { return 18.0; }
    String getType() { return "SUV"; }

    double calculateNightFare() {
        return calculateFare() * (1.0 + NIGHT_SURCHARGE);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase(Locale.ROOT);

            Cab cab;
            switch (type) {
                case "MINI": cab = new MiniCab(km); break;
                case "SEDAN": cab = new SedanCab(km); break;
                case "SUV": cab = new SUVCab(km); break;
                default: throw new IllegalArgumentException("Unknown cab type: " + type);
            }

            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(type + ": night service not available");
                    continue;
                }
                NightService nightCab = (NightService) cab;
                double fare;
                if (cab instanceof SedanCab) {
                    fare = ((SedanCab) cab).calculateNightFare();
                } else {
                    fare = ((SUVCab) cab).calculateNightFare();
                }
                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
                total += fare;
            } else {
                double fare = cab.calculateFare();
                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
