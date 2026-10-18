package helloInterview.dsa.dp;

public class KnapSack {
    public static int knapsack(int[] val, int[] wt, int W) {
        int n = val.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            // Traverse backward so each item is used at most once.
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(
                        dp[j],
                        val[i] + dp[j - wt[i]]
                );
            }
        }

        return dp[W];
    }
    public static void main(String[] args) {
        System.out.println(knapsack(
                new int[]{1, 2, 3},
                new int[]{4, 5, 1},
                4
        )); // 3

        System.out.println(knapsack(
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                3
        )); // 0

        System.out.println(knapsack(
                new int[]{10, 40, 30, 50},
                new int[]{5, 4, 2, 3},
                5
        )); // 80
    }
}
