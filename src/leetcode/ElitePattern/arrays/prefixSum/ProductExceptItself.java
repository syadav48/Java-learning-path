package leetcode.ElitePattern.arrays.prefixSum;

import java.util.Arrays;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int p1 = 1;
        int p2 = 0;
        int[] res = new int[nums.length];
        boolean isZero = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                isZero = !isZero;
            }
            if(nums[i] != 0){
                p1 *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 && !isZero){
                res[i] = p1/nums[i];
            } else if(nums[i] == 0 && isZero) {
                res[i] = p1;
            } else {
                res[i] = p2;
            }
        }
        return res;
    }
    public int[] optimizedProductExceptSelf(int[] nums){
        int zeroCount = 0;
        int product = 1;
        int[] res = new int[nums.length];
        for(int num: nums){
            if(num == 0) zeroCount++;
            else product *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            if(zeroCount > 1) res[i] = 0;
            else if(zeroCount == 1) res[i] = (nums[i] == 0) ? product : 0;
            else res[i] = product/nums[i];
        }
        return res;

    }
    //result[i] = product of elements before i * product of elements after i
    public int[] optimizedV2ProductExceptSelf(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
            System.out.println(prefix);
        }
        int suffix = 1;
        for (int i = n - 1; i >=0 ; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
            System.out.println(suffix);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductExceptItself productExceptItself = new ProductExceptItself();
        System.out.println(Arrays.toString(productExceptItself.optimizedV2ProductExceptSelf(nums)));
    }
}
