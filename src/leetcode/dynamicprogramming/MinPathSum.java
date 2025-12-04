package leetcode.dynamicprogramming;

import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        dp[0][0] = grid[0][0];
        //first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.println(i + " " + j + " " +  dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }
}
