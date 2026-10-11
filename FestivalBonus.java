import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    PartTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTime(name, salary));
                    break;

                case "PARTTIME":
                    employees.add(new PartTime(name, salary));
                    break;

                case "INTERN":
                    employees.add(new Intern(name, salary));
                    break;
            }
        }

        double total = 0;

        for (Employee e : employees) {
            double bonus = e.calculateBonus();

            System.out.printf(Locale.US, "%s: %.2f%n",
                    e.name, bonus);

            total += bonus;
        }

        System.out.printf(Locale.US,
                "Total Bonus: %.2f%n", total);

        sc.close();
    }
}