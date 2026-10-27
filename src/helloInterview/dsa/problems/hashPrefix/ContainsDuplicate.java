package helloInterview.dsa.problems.hashPrefix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    public boolean containsDuplicateOPt(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate.containsDuplicateOPt(nums));
    }
}
