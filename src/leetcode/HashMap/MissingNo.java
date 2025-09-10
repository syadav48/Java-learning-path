package leetcode.HashMap;

import java.util.*;

public class MissingNo {
    public int missingNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        for(int i = 0; i <= list.size(); i++){
            if(!list.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public int missingNum(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num, true);
        }
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        System.out.println(map);
        return -1;
    }
    public static void main(String[] args) {
        MissingNo missingNo = new MissingNo();
        int[] nums = {3,0,1};
        int res = missingNo.missingNumber(nums);
        int result = missingNo.missingNum(nums);
        System.out.println(res);
    }
}
