package leetcode.prefixSum;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountPartitions {
    public int countPartitions(int[] nums) {
        int count = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length - 1; i++){
            int firstHalf = prefixSum[i];
            int secondHalf = prefixSum[nums.length - 1] - prefixSum[i];
            int diff = firstHalf - secondHalf;
            if(diff % 2 == 0){
                count++;
            }
        }
        return count;
    };
    public static void main(String[] args) {
        int[] nums = {10,10,3,7,6};
        int[] nums1 = {1,2,2};
        int[] nums2 = {2,4,6,8};
        CountPartitions countPartitions = new CountPartitions();
        System.out.println(countPartitions.countPartitions(nums));
        System.out.println(countPartitions.countPartitions(nums1));
        System.out.println(countPartitions.countPartitions(nums2));
    }
}
