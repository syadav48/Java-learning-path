package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        RunningSum runningSum = new RunningSum();
        int[] nums = {1,2,3,4};
        int[] nums1 = {3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum.runningSum(nums)));
        System.out.println(Arrays.toString(runningSum.runningSum(nums1)));

    }
}
