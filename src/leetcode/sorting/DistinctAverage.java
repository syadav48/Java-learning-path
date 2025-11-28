package leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctAverage {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        List<Float> list = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        while (right >= left){
            float avg = (float) (nums[left] + nums[right]) /2;
            System.out.println(avg);
            list.add(avg);
            left++;
            right--;
        }
        System.out.println(list);
        return list.stream().distinct().toList().size();
    }
    public static void main(String[] args) {
        int[] nums = {4,1,4,0,3,5};
        int[] nums1 = {9,5,7,8,7,9,8,2,0,7};
        DistinctAverage distinctAverage = new DistinctAverage();
        System.out.println(distinctAverage.distinctAverages(nums));
        System.out.println(distinctAverage.distinctAverages(nums1));
    }
}
