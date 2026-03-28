package Interview.epam;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void moveZeroes(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroesToEnd.moveZeroes(nums);
    }
}
