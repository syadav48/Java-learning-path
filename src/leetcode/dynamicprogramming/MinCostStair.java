package leetcode.dynamicprogramming;

import java.util.Arrays;

public class MinCostStair {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int takeOne = dp[i - 1] + cost[i - 1];
            int takeTwo = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOne, takeTwo);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        MinCostStair minCostStair = new MinCostStair();
        int[] cost = {10, 15, 20};
        System.out.println(minCostStair.minCostClimbingStairs(cost));
    }
}
