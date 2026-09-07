package helloInterview.dsa.twoPointer;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if(nums[i] + nums[left] > nums[right]){
                    count++;
                    left++;
                } else if (nums[i] + nums[left] < nums[right]) {
                    right--;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return count;
    }
    public int triangleNumberOpt(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >=2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right){
               if(nums[left] + nums[right] > nums[i]){
                   count += right - left;
                   right--;
               } else {
                   left++;
               }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber.triangleNumberOpt(nums));
    }
}
