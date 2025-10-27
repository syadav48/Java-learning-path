package leetcode.counting;


import java.util.*;
import java.util.stream.Collectors;

public class CountElements {
    public static int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > min && max > nums[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {11,7,2,15};
        int[] num1 = {-3,3,3,90};
        System.out.println(countElements(nums));
        System.out.println(countElements(num1));
    }
}
