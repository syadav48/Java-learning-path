package leetcode.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class MinSizeSubArrSum {
    public int minSubArrayLen(int target, int[] nums) {
        int[] array = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x.intValue()).toArray();
        int[] prefixSum = new int[array.length];
        prefixSum[0] = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            prefixSum[i+1] = prefixSum[i] + array[i+1];
        }
        for (int i = 0; i < prefixSum.length; i++) {
            if(prefixSum[i] == target){
                return i + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        MinSizeSubArrSum minSizeSubArrSum = new MinSizeSubArrSum();
        System.out.println(minSizeSubArrSum.minSubArrayLen(11, nums));
    }
}
