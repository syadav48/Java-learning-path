package leetcode.sorting;

import java.util.Arrays;

public class MaximizeDiff {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = nums.length - 1; i > nums.length - 3; i--){
            sum += nums[i];
        }
        sum -= nums[0];
        return sum;
    }
    public static void main(String[] args) {
        MaximizeDiff maximizeDiff = new MaximizeDiff();
        int[] nums = {1,2,4,5};
        System.out.println(maximizeDiff.maximizeExpressionOfThree(nums));
    }
}
