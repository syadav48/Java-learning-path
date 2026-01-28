package leetcode.ElitePattern.arrays.prefixSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int[] preFixSum = new int[nums.length];
        preFixSum[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            preFixSum[i] = preFixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(preFixSum));
        for (int i = 0; i < preFixSum.length; i++) {
            if((preFixSum[i] - nums[i])/k >= 1){
                count++;
            } else if(preFixSum[i]/k >= 1){
                count++;
            }
        }
        return count;
    }
    public int optimizedSubarraySum(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);
       int sum = 0;
       int count = 0;
       for(int num: nums){
           sum += num;

           if(map.containsKey(sum - k)){
               count += map.get(sum - k);
           }

           map.put(sum, map.getOrDefault(sum, 0) + 1);
       }
       return count;
    }
    public static void main(String[] args) {
        SubArraySum sum = new SubArraySum();
        int[] nums = {1,2,3};
        System.out.println(sum.subarraySum(nums, 2));
    }
}
