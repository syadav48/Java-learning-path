package helloInterview.dsa.slidingWindow;

public class MaximumSumOfSubArray {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSumSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSumSoFar = Math.max(maxSumSoFar, currSum);
        }
        return maxSumSoFar;

    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // - 2
        // -1 , 4, 5, 6
        MaximumSumOfSubArray maximumSum = new MaximumSumOfSubArray();
        System.out.println(maximumSum.maxSubArray(nums));
    }
}
