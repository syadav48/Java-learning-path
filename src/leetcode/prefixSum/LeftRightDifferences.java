package leetcode.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRightDifferences {
    public static int[] leftRightDifference(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix1 = new int[nums.length];
        prefix1[0] = 0;
        int[] prefix2 = new int[nums.length];
        prefix2[0] = 0;
        for(int i = 1; i < prefix1.length; i++){
            prefix1[i] = prefix1[i - 1] + nums[i - 1];
        }
        for(int i = 1; i < nums.length; i++){
            prefix2[i] = prefix2[i - 1] + nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            int absdiff = prefix1[i] - prefix2[nums.length - 1 - i];
            res[i] = Math.abs(absdiff);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        //0, 3, 11, 15
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
}
