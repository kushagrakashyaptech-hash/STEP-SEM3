import java.util.HashMap;

public class Problem4_EmployeeIDLookup {

    public static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> lookup = new HashMap<String, String>();

        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }

        return lookup;
    }

    public static String getDepartment(HashMap<String, String> lookup, String employeeId) {
        if (lookup.containsKey(employeeId)) {
            return lookup.get(employeeId);
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };

        HashMap<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
