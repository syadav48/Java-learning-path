package leetcode.arrays;

import java.util.Arrays;

public class MinSum {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum % k;
    }
    public static void main(String[] args) {
        MinSum minSum = new MinSum();
        int[] nums = {3,9,7};
        int k = 5;
        System.out.println(minSum.minOperations(nums, k));
    }
}
