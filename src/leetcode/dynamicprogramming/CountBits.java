package leetcode.dynamicprogramming;

import java.util.Arrays;

public class CountBits {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(78)));
    }
}
