package helloInterview.dsa.problems.arrString;

public class BestTimeToBuy {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            currMin = Math.min(currMin, prices[i]);
            max = Math.max(max, prices[i] - currMin);
        }
        return max;
    }
    public static void main(String[] args) {
        BestTimeToBuy buy = new BestTimeToBuy();
        int[] prices = {7,1,5,3,6,4};
        int[] prices1 = {7,6,4,3,1};
        //
        System.out.println(buy.maxProfit(prices));
        System.out.println(buy.maxProfit(prices1));
    }
}
