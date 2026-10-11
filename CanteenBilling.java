import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
    abstract String getType();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers.add(new Student(amount));
                    break;
                case "STAFF":
                    customers.add(new Staff(amount));
                    break;
                case "GUEST":
                    customers.add(new Guest(amount));
                    break;
            }
        }

        double total = 0;

        for (Customer c : customers) {
            double finalAmount = c.calculateAmount();

            System.out.printf(Locale.US, "%s: %.2f%n",
                    c.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}