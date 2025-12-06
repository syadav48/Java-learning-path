package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateString {
    public List<String> generateParenthesis(int n) {
        //()
        //()(), (())
        //((())), (())(), ()(()), ()()(), (()())

        List<List<String>> strings = new ArrayList<>(List.of());
        strings.add(List.of("()"));
        for (int i = 1; i < n; i++) {
            System.out.println(i);
            strings.add(i, List.of("(" + strings.get(i - 1) + ")"));
            strings.add(i, List.of(strings.get(i - 1) + "()"));
        }
        return strings.get(n - 1);
    }
    public static void main(String[] args) {
        GenerateString generateString = new GenerateString();
        System.out.println(generateString.generateParenthesis(2));
    }
}
