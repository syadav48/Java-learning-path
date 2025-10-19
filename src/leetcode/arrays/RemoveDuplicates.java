package leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
      return Arrays.stream(nums).boxed().toList().stream().distinct().toList().size();
    }
    public  static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
