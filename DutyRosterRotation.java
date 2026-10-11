import java.util.Arrays;

public class DutyRosterRotation {

    /**
     * Rotates the roster to the right by k positions.
     * Returns a new array and leaves the original array unchanged.
     */
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        long k = 2;

        String[] result = rotateRoster(names, k);
        System.out.println(Arrays.toString(result));

        // Example where k is larger than the roster length
        String[] result2 = rotateRoster(names, 7);
        System.out.println(Arrays.toString(result2));
    }
}
