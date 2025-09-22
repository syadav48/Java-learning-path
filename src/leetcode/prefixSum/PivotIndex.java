package leetcode.prefixSum;

import java.util.Arrays;

public class PivotIndex {
    public static int pivotIndex(int[] nums){
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        return prefixSum[3];
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
