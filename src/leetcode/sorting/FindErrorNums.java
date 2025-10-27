package leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i + 1 != nums[i]){
                list.add(nums[i]);
                list.add(i + 1);
            }
        }
        int[] res = list.stream().mapToInt(x -> x).toArray();
        return res;
    };
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,4};
        int[] nums2 = {1,1};
        int [] nums3 = {3,2,2};
        System.out.println(Arrays.toString(findErrorNums(nums1)));
        System.out.println(Arrays.toString(findErrorNums(nums2)));
        System.out.println(Arrays.toString(findErrorNums(nums3)));
    }
}
