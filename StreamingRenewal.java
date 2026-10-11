import java.util.*;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Subscription {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Subscription> subscriptions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    subscriptions.add(new Basic(name, date));
                    break;

                case "STANDARD":
                    subscriptions.add(new Standard(name, date));
                    break;

                case "PREMIUM":
                    subscriptions.add(new Premium(name, date));
                    break;
            }
        }

        for (Subscription s : subscriptions) {
            System.out.println(
                    s.name + ": " + s.getRenewalDate()
            );
        }

        sc.close();
    }
}