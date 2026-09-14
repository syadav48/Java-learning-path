package helloInterview.dsa.greedyAlgo;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
      if(prices.length == 0){
          return 0;
      }
      int minPrice = prices[0];
      int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(buyAndSellStock.maxProfit(prices));
    }
}
