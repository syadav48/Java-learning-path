package leetcode.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LargestSumAfterK {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            } else {
                break;
            }
        };
        if(k % 2 == 1){
            int minIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] < nums[minIndex]) minIndex = i;
            }
            nums[minIndex] = -nums[minIndex];
        }
        return Arrays.stream(nums).sum();
    };
    public static void main(String[] args) {
        int[] nums1 = {4,2,3};
        int[] nums2 = {3,-1,0,2};
        int[] nums3 = {2,-3,-1,5,-4};
        int[] nums5 = {5,6,9,-3,3};
        int[] nums4 = {-2,9,9,8,4}; //32
        int k = 1;
        LargestSumAfterK largestSumAfterK = new LargestSumAfterK();
        System.out.println(largestSumAfterK.largestSumAfterKNegations(nums1, k));
        System.out.println(largestSumAfterK.largestSumAfterKNegations(nums2, 5));
        System.out.println(largestSumAfterK.largestSumAfterKNegations(nums3, 2));
        System.out.println(largestSumAfterK.largestSumAfterKNegations(nums4, 5));
        System.out.println(largestSumAfterK.largestSumAfterKNegations(nums5, 2));

    }
}
