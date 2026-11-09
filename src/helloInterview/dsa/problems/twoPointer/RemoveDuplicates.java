package helloInterview.dsa.problems.twoPointer;

import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            if(nums[start] != nums[end]){
                start++;
            }
            nums[start] = nums[end];
        }

        return start + 1;
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
}
