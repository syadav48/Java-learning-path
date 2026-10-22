package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            if(nums[start] != nums[end]){
                start++;
                nums[start] = nums[end];
            }
        }
        System.out.println(Arrays.toString(nums));
        return start + 1;
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // {1,2,0}
        int[] nums1 = {1,1,2}; // {1,2,0}
        System.out.println(removeDuplicates.removeDuplicates(nums));
        System.out.println(removeDuplicates.removeDuplicates(nums1));
    }
}
