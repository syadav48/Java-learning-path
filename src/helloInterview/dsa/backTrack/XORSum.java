package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;

public class XORSum {
    public int subsetXORSum(int[] nums) {
        return backTrack(nums, 0, 0);
    }

    private int backTrack(int[] nums, int start, int currentXOR) {
        if(start == nums.length){
            return currentXOR;
        }
        // include/choose
        int include = backTrack(nums, start + 1, currentXOR ^ nums[start]);

        // exclude
        int exclude = backTrack(nums, start + 1, currentXOR);

        return include + exclude; // sum of all subsets
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        XORSum x = new XORSum();
        System.out.println(x.subsetXORSum(nums));
    }
}
