public class Problem5_DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        // Count how many times each dice value appears.
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        System.out.print("Counts: ");
        for (int value = 1; value <= 6; value++) {
            System.out.print(value + ":" + count[value] + " ");
        }
        System.out.println();

        // Build the sorted result in increasing order.
        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int j = 0; j < count[value]; j++) {
                sorted[index] = value;
                index++;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted = diceSort(rolls);

        System.out.print("Sorted: ");
        for (int roll : sorted) {
            System.out.print(roll + " ");
        }
        System.out.println();
    }
}
