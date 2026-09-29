package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
    public boolean canTransform(int[] source, int[] target) {
        int sumSource = Arrays.stream(source).sum();
        int sumTarget = Arrays.stream(target).sum();
        if(sumSource != sumTarget) return false;
        long zeroInTarget = Arrays.stream(target).filter(x -> x == 0).count();
        long zeroInSource = Arrays.stream(source).filter(x -> x == 0).count();
        if(zeroInTarget > 1 && zeroInSource == 0){
            return false;
        }
        return true;
    }
    public int longestSubarray(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int[] cloned = nums.clone();
        int remainder = sum % k;
        if(remainder == 0){
            return nums.length;
        }
        if(remainder > 0){
            for(int i = 0; i < nums.length; i++){
                if(remainder == nums[i]){
                    cloned[i] = -nums[i];
                    int sum1 = Arrays.stream(cloned).sum();
                    System.out.println(sum1);
                    if(sum1 % k == 0){
                        return nums.length;
                    }
                }
            }
        }
        return nums.length - 1;
    }
    public int longestSubarrayOpt(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        for(int prefix: prefixSum){

        }
        return -1;
    }
    public static void main(String[] args) {
        Transform transform = new Transform();
        int[] source = {1,2,3};
        int[] target = {0,2,4};
        int[] nums = {4,1,2};
        int k = 3;
        System.out.println(transform.longestSubarrayOpt(nums, k));
        System.out.println();
    }
}
