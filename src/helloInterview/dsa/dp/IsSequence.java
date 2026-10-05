package helloInterview.dsa.dp;

import java.util.Arrays;
import java.util.Stack;

public class IsSequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return false;
        }
        int m = s.length();
        int n = t.length();
        int lenth = Math.min(m, n);
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == t.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n] == lenth;
    }

    public boolean isSubsequenceTwoPointer(String s, String t){
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    public boolean isSubsequenceStack(String s, String t){
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!stack.isEmpty() && t.charAt(i) == stack.peek()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        IsSequence isSequence = new IsSequence();
        String s = "abc";
        String t = "";
        System.out.println(isSequence.isSubsequence(s, t));
    }
}
