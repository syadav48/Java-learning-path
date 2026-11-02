package helloInterview.dsa.problems.hashPrefix;

import java.util.HashMap;
import java.util.Map;

public class SubArrayDivK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for(int num: nums){
            prefixSum += num;
            int rem = prefixSum % k;
            if(rem < 0){
                rem += k;
            }
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);

        }
        System.out.println(map);
        return count;
    }
    public static void main(String[] args) {
        SubArrayDivK subArrayDivK = new SubArrayDivK();
        int[] nums = {4,5,0,-2,-3,1};
        System.out.println(subArrayDivK.subarraysDivByK(nums, 9));
    }
}
