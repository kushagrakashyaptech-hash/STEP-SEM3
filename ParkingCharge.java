import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10.0;
    }

    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }

    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return Math.max(hours * 50.0, 100.0);
    }

    String getType() {
        return "TRUCK";
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
            }
        }

        double total = 0;

        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();

            System.out.printf(Locale.US, "%s: %.2f%n",
                    v.getType(), charge);

            total += charge;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}