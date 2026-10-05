package helloInterview.dsa.dp;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];

    }
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(8));
    }
}
