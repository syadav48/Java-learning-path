package leetcode.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    public int dominantIndex(int[] nums) {
        int largest = Arrays.stream(nums).max().getAsInt();
        List<Integer> list = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).toList();
        int secondLargest = list.get(1);
        for(int i = 0; i < nums.length; i++){
           if(largest >= secondLargest * 2){
               if(largest == nums[i]){
                   return i;
               }
           }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {3,6,1,0};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,2,3,4,5,6,12};
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.dominantIndex(nums1));
        System.out.println(largestNumber.dominantIndex(nums2));
        System.out.println(largestNumber.dominantIndex(nums3));

    }
}
