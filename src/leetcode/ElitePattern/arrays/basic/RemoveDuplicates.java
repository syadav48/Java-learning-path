package leetcode.ElitePattern.arrays.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }

        return list.size();
    }
    public int optimizedremoveDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; // index for next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.optimizedremoveDuplicates(nums));

    }
}
