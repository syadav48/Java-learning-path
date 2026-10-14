package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSumWays {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrackSum(nums, target, 0, 0);
        return count;
    }

    private void backTrackSum(int[] nums, int target, int index, int currentSum) {
       if(index == nums.length){
            if(currentSum == target){
                count++;
            }
            return;
       }

       // choose  +nums[index]
       backTrackSum(nums, target, index + 1, currentSum + nums[index]);

        // choose -nums[index]
       backTrackSum(nums, target, index + 1, currentSum - nums[index]);

    }

    public static void main(String[] args) {
        TargetSumWays targetSumWays = new TargetSumWays();
        int[] nums = {1,1,1,1,1};
        System.out.println(targetSumWays.findTargetSumWays(nums, 3));
    }
}
