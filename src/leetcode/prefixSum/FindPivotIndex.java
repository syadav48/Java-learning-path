package leetcode.prefixSum;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];
        left[0] = 0;
        right[right.length - 1] = 0;
        for (int i = 1; i < nums.length + 1; i++){
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i > 0; i--){
            System.out.println(i + " r " + right[i]);
           right[i] = right[i + 1] + nums[i + 1];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return 5;
    }
    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(findPivotIndex.pivotIndex(nums));
    }
}
