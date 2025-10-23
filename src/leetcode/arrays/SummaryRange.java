package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if(i == nums.length || nums[i] != nums[i - 1] + 1){
                if(start == nums[i - 1]){
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + nums[i - 1]);
                }
                if(i < nums.length) start = nums[i];
            }
        }
        return list;
    };
    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
}
