import java.util.*;

abstract class Room {
    double units;

    Room(double units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class SingleRoom extends Room {
    SingleRoom(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0;
    }

    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class AcRoom extends Room {
    AcRoom(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 10.0 + 200;
    }

    String getType() {
        return "AC";
    }
}

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;

                case "AC":
                    rooms.add(new AcRoom(units));
                    break;
            }
        }

        double total = 0;

        for (Room room : rooms) {
            double bill = room.calculateBill();

            System.out.printf(Locale.US, "%s: %.2f%n",
                    room.getType(), bill);

            total += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}