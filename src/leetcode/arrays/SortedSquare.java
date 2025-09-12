package leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortedSquare {
    public static int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).boxed().map(x -> x * x).sorted(Comparator.naturalOrder()).mapToInt(x -> x.intValue()).toArray();
    }
    public static void main(String[] args) {
        int[] nums1 = {-7, -3, 2, 3, 11};
        int[] nums2 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }
}
