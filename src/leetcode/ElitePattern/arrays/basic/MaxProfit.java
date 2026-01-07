package leetcode.ElitePattern.arrays.basic;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Math.min(prices[0], prices[1]);
        int diff = prices[1] - prices[0];

        for (int i = 2; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            diff = Math.max(diff, (prices[i] - min));
        }
        return diff;
    }
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7,1,5,3,6,4};
        maxProfit.maxProfit(prices);
    }
}
