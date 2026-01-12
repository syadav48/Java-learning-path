package leetcode.ElitePattern.arrays.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(List.of());
        for (int i = 0; i < nums.length; i++){
            int[] twoSumreturn = twoSum(nums, nums[i]);
            System.out.println(Arrays.toString(twoSumreturn));
            if(Arrays.stream(twoSumreturn).sum() == 0){
                List<Integer> list1 = Arrays.stream(twoSumreturn).boxed().toList();
                list.add(list1);
            }
        }
        return list;
    };
    public int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int complement = target - arr[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), arr[i], target};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}
