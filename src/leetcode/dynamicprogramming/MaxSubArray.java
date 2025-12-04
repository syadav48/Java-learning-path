package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Map;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        if(nums.length == 1){
            return nums[0];
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            System.out.println(sum + " " + i + " " + j);
            maxSum = Math.max(maxSum, sum);
            if(i == j) break;
            if(nums[j] > nums[i]){
                i++;
            } else {
                j--;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
    int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
    MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
