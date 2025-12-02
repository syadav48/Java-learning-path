package leetcode.dynamicprogramming;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int min = Math.min(prices[0], prices[1]);
        int diff = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            diff = Math.max(diff, prices[i] - min);
        }
        return Math.max(diff, 0);
    }
    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(prices1));
        System.out.println(maxProfit.maxProfit(prices2));
    }
}
