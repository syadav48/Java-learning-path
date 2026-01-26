package leetcode.ElitePattern.arrays.prefixSum;

import java.util.Arrays;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int res1 = 1, res2 = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                res1 *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){

            }
            res[i] = res1/nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductExceptItself productExceptItself = new ProductExceptItself();
        System.out.println(Arrays.toString(productExceptItself.productExceptSelf(nums)));
    }
}
