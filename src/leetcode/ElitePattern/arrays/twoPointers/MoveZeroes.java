package leetcode.ElitePattern.arrays.twoPointers;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if(nums[end] != 0){
                nums[start] = nums[end];
                start++;
            }
        }
        while (start < nums.length){
            nums[start] = 0;
            start++;
        }
        System.out.println(Arrays.toString(nums));

    }
    public void AdvancedMoveZeroes(int[] nums) {
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if(nums[end] != 0){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12}; //1,3,4
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        moveZeroes.AdvancedMoveZeroes(nums);
        //start - nonzero
        // end - zero
    }
}
