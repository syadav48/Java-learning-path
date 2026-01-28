package leetcode.ElitePattern.arrays.prefixSum;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        int right = nums.length - 1;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            max = Math.max(max, prefixSum[i]);
        }
        while (left <= right){
            sum = prefixSum[right] - prefixSum[left];
            max = Math.max(max, sum);
            left++;
            right--;
        }
        return max;
    }

    public int optimizedMaxSubArray(int[] nums){
        int maxSoFar = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currSum);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; //1
        System.out.println(maxSubArray.optimizedMaxSubArray(nums));
    }
}
