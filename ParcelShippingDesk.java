import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
    abstract String getType();

    double calculateInsurance() {
        return 0.0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40.0 + 10.0 * weightKg;
    }

    String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    String getType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40.0 + 10.0 * weightKg + 50.0;
    }

    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    String getType() { return "FRAGILE"; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, value));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, value));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, value));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
            grandTotal += total;
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
