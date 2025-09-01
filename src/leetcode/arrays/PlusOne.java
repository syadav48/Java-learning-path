package leetcode.arrays;

import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
         List<int[]> arr = Arrays.asList(digits);
        System.out.println(arr);
        return digits;
    }
    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] nums = {1, 2, 3};
        obj.plusOne(nums);
    }
}
