package leetcode.slidingWindow;

import java.util.Arrays;

public class MaxAvg {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxSum = windowSum;
        for(int i = k; i < nums.length; i++){
           windowSum += nums[i] - nums[i - k];
           maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum/k;
    }
    public static void main(String[] args) {
        MaxAvg maxAvg = new MaxAvg();
        int[] nums = {0,4,0,3,2}; // 4, 5, 6
        // 2, 51, 42
        System.out.println(maxAvg.findMaxAverage(nums, 1));
    }
}
