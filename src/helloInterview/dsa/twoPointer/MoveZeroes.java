package helloInterview.dsa.twoPointer;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left){
            if(nums[left] == 0){
                nums[right] = nums[left];
                nums[left] = nums[left + 1];
            }
            right--;
            left++;
            System.out.println(left
                    +" left: " + right + " right");
        }
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroesOpt(int[] nums) {
        int nextNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[nextNonZero];
                nums[nextNonZero] = nums[i];
                nums[i] = temp;
                nextNonZero++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        moveZeroes.moveZeroesOpt(nums);
    }
}
