package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if(nums[end] != 0){
                nums[start++] = nums[end];
            }
        }
        for (int i = nums.length - 1; i >= start; i--) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroess(int[] nums) {
        int left = 0;
        for(int right = 0; right <= nums.length - 1; right++){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                System.out.println(Arrays.toString(nums));
            }
        }
        //System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {1,0,0,3,12};
        moveZeroes.moveZeroess(nums);
    }
}
