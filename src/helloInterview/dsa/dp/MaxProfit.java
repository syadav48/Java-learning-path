package helloInterview.dsa.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        if(prices.length == 1){
            return 0;
        }
        int[] dp = new int[prices.length - 1];
        dp[0] = prices[1] - prices[0];
        int diff = dp[0];
        for (int i = 1; i < prices.length - 1; i++) {
            min = Math.min(min, prices[i]);
            diff = Math.max(diff, prices[i] - min);
           maxProfit = Math.max(maxProfit, diff);
        }
        return maxProfit;

    }
    public int maxProfitOpt(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {1,2};
        System.out.println(maxProfit.maxProfit(prices));
    }
}
