package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//        dp[n] = "(" + dp[inside] + ")" + dp[outside]
//inside = i
//        outside = n - 1 - i

public class GenerateString2 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(List.of(""));
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int inside = 0; inside < i; inside++) {
                int outside = i - 1 - inside;
                for(String in: dp.get(inside)) {
                    for (String out : dp.get(outside)) {
                        current.add("(" + in + ")" + out);
                    }
                }
            }
            dp.add(current);
        }
        return dp.get(n);
    }
    public static void main(String[] args) {
        GenerateString2 generateString2 = new GenerateString2();
        System.out.println(generateString2.generateParenthesis(15));
    }
}
