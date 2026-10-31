
public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max]) {
                    max = j;
                }
            }

            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks = {45, 90, 60, 75};

        int swaps = prizeTable(marks);

        System.out.print("Sorted Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        System.out.println("\nSwaps = " + swaps);
    }
}
