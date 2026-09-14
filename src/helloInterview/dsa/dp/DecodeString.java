package helloInterview.dsa.dp;

import java.util.Arrays;

public class DecodeString {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int digit = Character.getNumericValue(s.charAt(i-1));
            if(digit != 0){
                dp[i] += dp[i - 1];
            }
            digit = Integer.parseInt(s.substring(i-2, i));
            if(digit >= 10 && digit <= 26){
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];

    }
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();

        System.out.println(decodeString.numDecodings("12"));
        System.out.println(decodeString.numDecodings("226"));
        System.out.println(decodeString.numDecodings("06"));
        // 1, 1, 1 -
    }
}
