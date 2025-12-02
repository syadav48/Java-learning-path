package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

// Top-Down Approach: memoization
public class FibonacciMemo {
    static Map<Integer, Integer> memo = new HashMap<>();

    static int fib(int n){
        if(n <= 1) return n;
        if(memo.containsKey(n)) return memo.get(n);
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }
    public static void main(String[] args) {
        int num = 100;
        System.out.println(fib(num));
    }
}
