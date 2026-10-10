package helloInterview.dsa.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            maxSum = Math.max(maxSum, nums[i]);
        }
        list.add(maxSum);
        for (int i = k; i < nums.length; i++) {
                maxSum = Math.max(maxSum, nums[i]);
                list.add(maxSum);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public static void main(String[] args) {
        Level1 level1 = new Level1();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums1 = {1};
        int[] nums2 = {1,-1};
        // end - 0, start - 0, k - 3
        System.out.println(Arrays.toString(level1.maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(level1.maxSlidingWindow(nums1, 1)));
        System.out.println(Arrays.toString(level1.maxSlidingWindow(nums2, 1)));
    }
}
