package helloInterview.dsa.problems.hashPrefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckSubArrSum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k == 0) return true;
        for (int i = 0; i < nums.length - 1; i++) {
            if((sum - nums[i]) % k == 0){
                return true;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if((sum - nums[i]) % k == 0){
                return true;
            }
        }
        return false;
    }
    public boolean checkSubarraySumOpt(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2){
                    return true;
                }

            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CheckSubArrSum checkSubArrSum = new CheckSubArrSum();
        int[] nums = {23, 2, 6, 4, 7}; // 42
        int k = 6;
        System.out.println(checkSubArrSum.checkSubarraySum(nums, k));
    }
}
