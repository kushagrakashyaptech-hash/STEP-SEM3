import java.util.*;

interface UsesCollegeBus {
    double TRANSPORT_FEE = 12000.0;
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuitionFee();

    double calculateTotalFee() {
        double total = tuitionFee();
        if (this instanceof UsesCollegeBus) {
            total += UsesCollegeBus.TRANSPORT_FEE;
        }
        return total;
    }

    String getName() {
        return name;
    }
}

class DayScholar extends Student implements UsesCollegeBus {
    DayScholar(String name) { super(name); }
    double tuitionFee() { return 40000.0; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    double tuitionFee() { return 40000.0 + 60000.0; }
}

class ScholarshipStudent extends Student implements UsesCollegeBus {
    ScholarshipStudent(String name) { super(name); }
    double tuitionFee() { return 20000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown student type: " + type);
            }
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", student.getName(), fee);
            totalCollected += fee;
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
