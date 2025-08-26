package leetcode.arrays;

import java.util.*;

class  Major {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int length = nums.length;
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (entry.getValue() > Math.abs(length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int a = i - j;
                if(nums[i] == nums[j] && k >= Math.abs(a) ){
                       return true;
                }
            }
        }
        return false;
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            }
            else if(i % 5 == 0){
                list.add("Buzz");
            }
            else if(i % 3 == 0){
                list.add("Fizz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
        Major obj = new Major();
        int [] nums = {2,2,1,1,1,2,2};
        int [] dups = {1,2,3,1};
        System.out.println(obj.fizzBuzz(15));
        System.out.println(obj.majorityElement(nums));
        System.out.println(obj.containsNearbyDuplicate(dups, 3));

    }
}
