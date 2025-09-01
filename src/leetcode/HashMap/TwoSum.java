package leetcode.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int k = 0;
        int[] resNum = new int[2];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        System.out.println(map);
        while (k < nums.length){
           for(int j=k+1; j<nums.length; j++){
              if(map.get(k) + map.get(j) == target){
                  resNum[0] = k;
                  resNum[1] = j;
              }
           }
           k++;
        }
        return resNum;
    }
    public int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println(complement + "" + map);
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] nums = {3, 2, 4};
        int[] res = sum.twoSums(nums, 6);
        System.out.println(Arrays.toString(res));

    }
}
