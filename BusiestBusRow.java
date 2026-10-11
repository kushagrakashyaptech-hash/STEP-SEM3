public class BusiestBusRow {

    /**
     * Returns the zero-based index of the row with the largest total,
     * and the total number of students in that row.
     * If multiple rows have the same maximum total, the first row wins.
     *
     * @param grid 2D array where each value is the number of students in a seat
     * @return int array: {rowIndex, rowTotal}
     */
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("Grid must contain at least one row.");
        }

        int bestRow = 0;
        int bestTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;

            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }

            // Update only when strictly larger, so ties keep the smaller index.
            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestRow = r;
            }
        }

        return new int[] {bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
