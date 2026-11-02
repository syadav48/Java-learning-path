package helloInterview.dsa.problems.hashPrefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for(int num: nums){
            prefixSum += num;
            if(prefixMap.containsKey(prefixSum - k)){
                count += prefixMap.get(prefixSum - k);
            }

            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        System.out.println(prefixMap);
        return count;
    }
    public static void main(String[] args) {
        SubArraySumEqualsK sumEqualsK = new SubArraySumEqualsK();
        int[] nums = {1,2,3,3};
        int[] nums1 = {1,1,1,2};
        //group-by; aggregation -> hashmap sure
        // 1+2, 3
        // 1+1, 1+1
        System.out.println(sumEqualsK.subarraySum(nums, 3));
        System.out.println(sumEqualsK.subarraySum(nums1, 2));
    }
}
