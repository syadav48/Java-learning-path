package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i; j++){
                list.add(nums[i]);
            }
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i; j++){
                list.add(nums[j]);
            }
            list.add(nums[i]);
            res.add(list);
        }

        return res;
    }
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(subsets.subsetsWithDup(nums));
    }
}
