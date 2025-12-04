package leetcode.dynamicprogramming;

public class MaxSubArray2 {
    public int maxSubArray(int[] nums){
        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
            System.out.println(max);
            System.out.println(current + " " + max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        MaxSubArray2 maxSubArray = new MaxSubArray2();
        System.out.println(maxSubArray.maxSubArray(nums));
        System.out.println();
    }
}
