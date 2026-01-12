package leetcode.arrays;

import java.util.Arrays;

public class TransformArray {
    public int[] transformArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if(nums[i] % 2 == 0){
                result[i] = 0;
            } else{
                result[nums.length - 1 - i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TransformArray transformArray = new TransformArray();
        int[] arr = {4,3,2,1}; // 0 1 0 1
        System.out.println(Arrays.toString(transformArray.transformArray(arr)));
    }
}
