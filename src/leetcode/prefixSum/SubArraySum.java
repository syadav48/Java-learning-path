package leetcode.prefixSum;

import java.util.Arrays;

public class SubArraySum {
    public int subarraySum(int[] nums) {
        int start;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            start = Math.max(0, i - nums[i]);
            int[] subarr = Arrays.copyOfRange(nums, start, i+1);
            arr[i] = Arrays.stream(subarr).sum();
        }
        return Arrays.stream(arr).sum();
    }
    public static void main(String[] args) {
        int[] nums = {3,1,1,2};
        SubArraySum subArraySum = new SubArraySum();
        System.out.println(subArraySum.subarraySum(nums));
    }
}
