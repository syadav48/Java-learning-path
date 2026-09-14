package helloInterview.dsa.dp;

import java.util.Arrays;

public class CountBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i/2] + (i % 2);
        }
        return dp;
    }
    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(Arrays.toString(countBits.countBits(8)));

//        0 --> 0 - 0
//        1 --> 1 - 1
//        2 --> 10 - 1
//        3 --> 11 - 2
//        4 --> 100 - 1
//        5 --> 101 - 2
//        6 --> 110 - 2
//        7 --> 111 - 3
//          8 --> 1000 - 1
    }
}
