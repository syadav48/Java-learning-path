package leetcode.ElitePattern.arrays.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxiumSubArray {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        int windowSum = 0;
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            if(!list.contains(num)){
                list.add(num);
            }
        }
        if(k >= list.size() ){
            return sum;
        }
        for (int i = 0; i < k; i++) {
            windowSum += list.get(i);
        }
        for (int i = k; i < list.size(); i++) {
            windowSum = windowSum + list.get(i) - list.get(i - k);
            sum = Math.max(sum, windowSum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        MaxiumSubArray maxiumSubArray = new MaxiumSubArray();
        System.out.println(maxiumSubArray.maximumSubarraySum(nums, 3));
    }
}
