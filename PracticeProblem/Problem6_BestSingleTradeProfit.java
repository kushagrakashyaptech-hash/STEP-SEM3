public class Problem6_BestSingleTradeProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minimumPrice;

            if (profit > maximumProfit) {
                maximumProfit = profit;
            }

            if (prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {
        int[] first = {7, 1, 5, 3, 6, 4};
        int[] second = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(first));
        System.out.println(maxProfit(second));
    }
}
