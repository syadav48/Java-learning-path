package leetcode.math;

import java.util.Arrays;

public class GetFinalState {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k > 0){
            int minIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] < nums[minIndex]){
                    minIndex = i;
                }
            }
            nums[minIndex] *= multiplier;
            k--;
        }
        return nums;
    }
    public static void main(String[] args) {
        GetFinalState getFinalState = new GetFinalState();
        int[] nums = {2,1,3,5,6};
        System.out.println(Arrays.toString(getFinalState.getFinalState(nums, 5, 2)));
    }
}
