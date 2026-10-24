package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if(Arrays.binarySearch(nums, i) < 0){
                return i;
            }
        }
        return -1;
    }
    public int missingNumberOpt(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int mul = n*(n+1);
        int res = mul/2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return res - sum;
    }
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {3,0,1};
        System.out.println(missingNumber.missingNumber(nums));
    }
}
