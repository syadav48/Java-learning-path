package helloInterview.dsa.problems.hashPrefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // two pointer only works in sorted array
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,9,11};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
    }
}
