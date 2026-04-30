package leetcode.slidingWindow;

import java.util.Arrays;

public class MinimumDiff {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;
        Arrays.sort(nums);
        int mindiff = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++){
            int diff = nums[i + k - 1] - nums[i];
            mindiff = Math.min(mindiff, diff);
        }
        return mindiff;
    }
    public static void main(String[] args) {
        MinimumDiff minimumDiff = new MinimumDiff();
        int[] nums = {9,4,1,7,8,5}; // 1,4,5,7,8,9 // - 1,4,5; 4,5,7; 5,7,8; 7,8,9
        int k = 3;
        System.out.println(minimumDiff.minimumDifference(nums, k));
    }
}
