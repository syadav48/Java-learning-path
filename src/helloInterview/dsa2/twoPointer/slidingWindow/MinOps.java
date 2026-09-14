package helloInterview.dsa2.twoPointer.slidingWindow;

import java.util.Arrays;

public class MinOps {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            if(nums[i] == 0){
                for (int j = i; j < i + 3; j++) {
                    nums[j] = 1 - nums[j];
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int num: nums){
            if(num == 0){
                return -1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        MinOps minOps = new MinOps();
        int[] nums = {0,1,1,1,0,0};
        int[] nums1 = {0,1,1,1};

        // 0,1,1,1
        // 1,0,0,1
        // 1,1,1,0
        //0001
        //1000
        //0111

        System.out.println(minOps.minOperations(nums));
        System.out.println(minOps.minOperations(nums1));
    }
}
