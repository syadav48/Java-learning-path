package leetcode.ElitePattern.arrays.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));
    }
    public void reverse(int[] nums, int start, int end){
        while (end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
       rotateArray.rotate(nums, 3);
    }
}
