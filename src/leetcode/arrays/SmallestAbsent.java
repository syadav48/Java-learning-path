package leetcode.arrays;

import java.util.*;

public class SmallestAbsent {
    public static int smallestAbsent(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            set.add(num);
            sum += num;
        }

        double avg = (double) sum / nums.length;

        // Start checking from just above avg
        int candidate = (int) Math.floor(avg) + 1;
        while (true) {
            if (candidate > 0 && !set.contains(candidate)) {
                return candidate;
            }
            candidate++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, -1};
        System.out.println(smallestAbsent(nums));
    }
}
