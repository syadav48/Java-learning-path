package leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << length); mask++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if((mask & (1 << i)) != 0){
                    list.add(nums[i]);
                }
            }
            result.add(list);
        }
        System.out.println(result);
        return result;
    };
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        PowerSet powerSet = new PowerSet();
        powerSet.subsets(nums);
    }
}
