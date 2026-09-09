package helloInterview.dsa.prefixSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public Integer subarraySum(int[] nums, Integer k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0, count = 0;
        for(int num: nums){
            sum += num;
            count += prefix.getOrDefault(sum - k, 0);
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        SubArraySum sum = new SubArraySum();
        System.out.println(sum.subarraySum(nums, k));
    }
}
