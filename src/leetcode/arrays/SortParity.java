package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SortParity {
    public static int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            if(num % 2 == 0){
                list.add(num);
            }
        }
        for(int num: nums){
            if(num % 2 != 0){
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static int[] sortArrayByParities(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                // swap odd on left with even on right
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }

        return nums;
    }
    public static int[] sortArrayByPar(int[] nums) {
        return IntStream.concat(
                Arrays.stream(nums).filter(x -> x % 2 == 0),
                Arrays.stream(nums).filter(x -> x % 2 != 0)
        ).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
}
