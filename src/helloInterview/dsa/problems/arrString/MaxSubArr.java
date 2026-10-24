package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class MaxSubArr {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public int maxSubArrayOpt(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            System.out.println(currSum + " : curr " + maxSum + " : max");
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArr maxSubArr = new MaxSubArr();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //
        System.out.println(maxSubArr.maxSubArrayOpt(nums));
    }
}
