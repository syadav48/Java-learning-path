package leetcode.prefixSum;

import java.util.Arrays;

public class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int[] arr = Arrays.copyOfRange(nums, left, right + 1);
        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}
