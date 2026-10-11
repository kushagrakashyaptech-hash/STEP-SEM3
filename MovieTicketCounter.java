import java.util.*;

abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getTicketPrice();
    abstract String getSeatType();

    double calculateAmount() {
        return count * (getTicketPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }
    double getTicketPrice() { return 150.0; }
    String getSeatType() { return "REGULAR"; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }
    double getTicketPrice() { return 250.0; }
    String getSeatType() { return "PREMIUM"; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) { super(count); }
    double getTicketPrice() { return 400.0; }
    String getSeatType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase(Locale.ROOT);
            int count = sc.nextInt();

            switch (seat) {
                case "REGULAR":
                    tickets.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    tickets.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    tickets.add(new ReclinerTicket(count));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
        }

        double total = 0.0;
        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", ticket.getSeatType(), amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
