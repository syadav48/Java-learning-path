package leetcode.arrays.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestHS {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0, maxLen = 0;
        while (right < nums.length){
            if(nums[right] - nums[left] != 1){
                left++;
            } else if (nums[right] - nums[left] == 1) {
                System.out.println("coming here");
                maxLen = Math.max(maxLen, right - left + 1);
            }
            System.out.println(left + " " + right);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        int [] numss = {1,1,1,1,1,1,3,5,5,6};
        System.out.println(findLHS(numss));
    }
}
