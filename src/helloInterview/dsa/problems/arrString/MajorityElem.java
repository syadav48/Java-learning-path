package helloInterview.dsa.problems.arrString;

import java.util.HashMap;
import java.util.Map;

public class MajorityElem {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        System.out.println(freq);
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue() > n / 2){
                return entry.getKey();
            }
        }
        return  -1;
    }
    public int majorityElementOpt(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int num: nums){
            if(count == 0){
                candidate = num;
            }

            if(candidate == num){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElem majorityElem = new MajorityElem();
        int[] nums = {2,3,3};
        int[] nums1 = {2,2,1,1,1,2,2};
        System.out.println(majorityElem.majorityElementOpt(nums1));
        System.out.println(majorityElem.majorityElementOpt(nums));
    }
}
