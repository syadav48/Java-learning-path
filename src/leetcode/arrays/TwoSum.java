package leetcode.arrays;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                   list.add(i);
                   list.add(j);
                }
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return  new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] res = twoSumHash(arr, 13);
        System.out.println(Arrays.toString(res));
    }
}
