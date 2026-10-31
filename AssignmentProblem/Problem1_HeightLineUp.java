public class Problem1_HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("Pass " + (i + 1) + ": ");
            for (int height : heights) {
                System.out.print(height + " ");
            }
            System.out.println();

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 5, 1};
        lineUp(heights);
    }
}
