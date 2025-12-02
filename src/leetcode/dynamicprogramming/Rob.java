package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rob {
    public int rob(int[] nums) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("even", new ArrayList<>());
        map.put("odd", new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0){
                map.get("even").add(nums[i]);
            } else {
                map.get("odd").add(nums[i]);
            }
        }
       int evenSum = map.get("even").stream().mapToInt(x -> x.intValue()).sum();
        int oddSum = map.get("odd").stream().mapToInt(x -> x.intValue()).sum();
        return Math.max(evenSum, oddSum);
    }
    public int dynamicRob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] nums1 = {2,1,1,2}; //4
        Rob rob = new Rob();
        System.out.println(rob.dynamicRob(nums));
        System.out.println(rob.dynamicRob(nums1));
    }
}
