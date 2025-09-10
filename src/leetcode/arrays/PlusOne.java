package leetcode.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                System.out.println(Arrays.toString(digits));
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.out.println(Arrays.toString(res));

        return res;
    };
    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] nums = {1, 9, 9};
        System.out.println(Arrays.toString(obj.plusOne(nums)));
    }
}
