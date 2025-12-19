package leetcode.math;

import java.util.Arrays;

public class MinOperations {
    public int minOperations(int[] nums, int k) {
        int reduce = Arrays.stream(nums).reduce(0, Integer::sum);
        return reduce % k;
    }
    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] nums = {3,2};
        int k = 6;
        System.out.println(minOperations.minOperations(nums, k));
    }
}
