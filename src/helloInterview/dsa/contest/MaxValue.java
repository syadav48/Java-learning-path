package helloInterview.dsa.contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxValue {
    public long maxValue(int[] nums) {
        Arrays.sort(nums);
        long start = nums[nums.length - 1];
        if(nums.length <= 2){
            return start - nums[0];
        }
        for (int end = nums.length - 2; end >= 0; end--) {
            if(end % 2 == 0){
                start -= nums[end];
            } else  {
                start += nums[end];
            }
        }
        System.out.println(Arrays.toString(nums));
        return start;

    }

    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        int[] nums = {18,-7,-10,1};
        System.out.println(maxValue.maxValue(nums));
    }
}
