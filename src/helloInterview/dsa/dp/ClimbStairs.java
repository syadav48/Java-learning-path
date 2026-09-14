package helloInterview.dsa.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public int climbStairsOpt(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbHelper(n, memo);
    }
    public int climbHelper(int i, Map<Integer, Integer> memo){
        if(i <= 1){
            return 1;
        }
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        memo.put(i, climbHelper(i - 1, memo) + climbHelper(i - 2, memo));
        return memo.get(i);
    }
    public int bottomUpApproach(int n){
        if(n <= 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int climbStairsBest(int n) {
        if (n <= 1) return 1;
        int prev1 = 1, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.bottomUpApproach(6));
    }
}
