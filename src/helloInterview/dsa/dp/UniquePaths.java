package helloInterview.dsa.dp;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        if(dp[0][0] == 1){
            return 0;
        }
        // first column: 
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i-1][0];
        }
        // first row:
        for(int i = 1; i < n; i++){
            dp[0][i] = (obstacleGrid[0][i] == 1) ? 0 : dp[0][i-1];
        }
        System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] obstacleGrid1 = {{1,0}};
        System.out.println(uniquePaths.uniquePathsWithObstacles(obstacleGrid1));
    }
}
