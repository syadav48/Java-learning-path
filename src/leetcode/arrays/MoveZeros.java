package leetcode.arrays;
import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for(int num : nums){
            if(num != 0){
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length){
            nums[insertPos++] = 0;
        }
        System.out.println(Arrays.toString(nums));


    }
    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int [] nums = {0,1,0,3,12};
        int [] num = {0};
        int [] num1 = {3, 2, 1};
        int [] num2 = {1, 2};
         obj.moveZeroes(nums);
         obj.moveZeroes(num);
    }
}
