import java.util.HashSet;

public class Problem3_TransactionDuplicateCheck {

    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<String>();

        for (String id : transactionIds) {
            if (seen.contains(id)) {
                return true;
            }
            seen.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        String[] first = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] second = {"TXN2001", "TXN2002", "TXN2003"};

        System.out.println(hasDuplicate(first));
        System.out.println(hasDuplicate(second));
    }
}
