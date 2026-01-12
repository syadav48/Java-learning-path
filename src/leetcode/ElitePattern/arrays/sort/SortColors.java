package leetcode.ElitePattern.arrays.sort;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
