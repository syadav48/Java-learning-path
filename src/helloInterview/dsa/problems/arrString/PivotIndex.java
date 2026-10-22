package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int[] prefixLeft = new int[nums.length+1];
        int[] prefixRight = new int[nums.length+1];
        prefixLeft[0] = 0;
        prefixRight[nums.length] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixLeft[i + 1] = prefixLeft[i] + nums[i];
        }
        for (int i = nums.length; i > 0; i--) {
            prefixRight[i - 1] = prefixRight[i] + nums[i - 1];
        }
        System.out.println(Arrays.toString(prefixLeft));
        System.out.println(Arrays.toString(prefixRight));
        for (int i = 0; i < prefixLeft.length; i++) {
            if(prefixLeft[i] == prefixRight[i + 1]){
                return i;
            }
        }
        return -1;
    }
    public int pivotIndexOpt(int[] nums) {
       int total = Arrays.stream(nums).sum();
       int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex.pivotIndexOpt(nums));
    }
}
