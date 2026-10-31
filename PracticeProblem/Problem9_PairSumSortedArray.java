public class Problem9_PairSumSortedArray {

    public static void pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[] first = {-4, -1, 0, 3, 5, 9};
        int[] second = {1, 2, 3};

        pairSumSorted(first, 4);
        pairSumSorted(second, 100);
    }
}
