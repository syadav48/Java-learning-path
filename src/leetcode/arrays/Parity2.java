 package leetcode.arrays;

import java.util.*;

public class Parity2 {
    public static int[] sortArrayByParityII(int[] nums) {
        int[] resNum = new int[nums.length];
        List<Integer> list1 = Arrays.stream(nums).boxed().filter(x -> x % 2 == 0).toList();
        List<Integer> list2 = Arrays.stream(nums).boxed().filter(x -> x % 2 != 0).toList();
        System.out.println(list1);
        System.out.println(list2);
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                resNum[i] = list1.get(i / 2);
            } else {
                resNum[i] = list2.get((i - 1 )/ 2);
            }
        }
        return resNum;
    }

    public static int[] sortArrayByParityIII(int[] nums) {
        int even = 0, odd = 1, n = nums.length;
        while (even < n && odd < n){
            if(nums[even] % 2 == 0){
                even += 2;
            } else if(nums[even] % 2 == 1){
                odd += 2;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even += 2;
                odd += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
        System.out.println(Arrays.toString(sortArrayByParityIII(nums)));
    }
}
