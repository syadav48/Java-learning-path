package leetcode.bitmanipulation;

import cses.MissingNo;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum(); // 37
        int n = nums.length;
        return ((n) * (n + 1)) / 2 - sum;
    };

    public int missingNumberUsingXOR(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            result ^= i;
        }
        for (int num : nums) {
            result ^= num;
        }
        return result;
    };

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
        System.out.println(missingNumber.missingNumberUsingXOR(nums));

    }
}
