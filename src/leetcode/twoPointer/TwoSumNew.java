package leetcode.twoPointer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumNew {
    // in case of sorted array this works
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if(nums[left] + nums[right] == target) return new int[]{left, right};
            else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    };

    public int[] newTwoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            System.out.println(complement + " " + hashMap);
            if(hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }
        System.out.println(hashMap);
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        TwoSumNew twoSumNew = new TwoSumNew();
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSumNew.newTwoSum(nums, target)));
    }
}
