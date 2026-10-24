package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum *= nums[j];
            }
            for (int j = 0; j < i; j++) {
                sum *= nums[j];
            }
            res[i] = sum;
        }
        return res;
    }
    public int[] productExceptSelfOpt(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        //prefix-product
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1]*nums[i-1];
        }
        //suffix-product
        System.out.println(Arrays.toString(res));
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
            System.out.println(suffix + ": suffix");
        }
        return res;
    }
    public static void main(String[] args) {
        ProductArrayExceptSelf productArrayExceptSelf = new ProductArrayExceptSelf();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productArrayExceptSelf.productExceptSelfOpt(nums)));
    }
}
