package helloInterview.dsa.slidingWindow;

public class MaximumSum {
    public Integer maxSum(int[] nums, Integer k) {
        int windowSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSum maximumSum = new MaximumSum();
        int[] nums = {2, 1, 5, 1, 3, 2};
        // 8 + 1
        Integer k = 3;
        System.out.println(maximumSum.maxSum(nums, k));
    }
}
