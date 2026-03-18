package leetcode.sorting;

import java.util.Arrays;

public class AbsDiff {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSum = 0;
        int minSum = 0;
        for (int i = 0; i < k; i++) {
            minSum += nums[i];
        }
        for (int i = nums.length - 1; i > nums.length - 1 - k; i--) {
            maxSum += nums[i];
        }
        return maxSum - minSum;
    };

    public static void main(String[] args) {
        AbsDiff absDiff = new AbsDiff();
        int[] nums = {5,2,2,4};
        System.out.println(absDiff.absDifference(nums, 2));
    }
}
