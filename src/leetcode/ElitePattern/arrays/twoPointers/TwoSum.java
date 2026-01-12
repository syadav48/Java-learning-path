package leetcode.ElitePattern.arrays.twoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        while (nums.length > start + 1){
            for (int end = start + 1; end < nums.length ; end++) {
                if(nums[start] + nums[end] == target){
                    return new int[]{start, end};
                }
            }
            start++;
        }
        return new int[]{-1, -1};
    };
    public int[] optimizedTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            int i1 = Arrays.binarySearch(nums, tar);
            if(i1 > 0){
                return new int[]{i, i1};
            }
        }
        return new int[]{-1, -1};
    };
    public int[] advancedTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    };
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 26;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum.optimizedTwoSum(nums, target)));
    }
}
