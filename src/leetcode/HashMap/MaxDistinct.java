package leetcode.HashMap;

import java.util.Arrays;
import java.util.HashSet;

public class MaxDistinct {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i >= 0 && set.size() < k; i--) {
            set.add(nums[i]);
        }
        return set.stream().sorted((a, b) -> b - a).mapToInt(x -> x).toArray();

    }
    public static void main(String[] args) {
        MaxDistinct maxDistinct = new MaxDistinct();
        int[] nums = {84,93,100,77,90, 90}; // 100, 93, 90, 84, 77
        int k = 3;
        System.out.println(Arrays.toString(maxDistinct.maxKDistinct(nums, k)));
    }
}
