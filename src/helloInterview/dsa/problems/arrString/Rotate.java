package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));
    }
    public void reverse(int[] nums, int left, int right){
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums1 = {-1,-100,3,99};
        // {7,6,5,1,2,3,4}
        rotate.rotate(nums, 2);
        rotate.rotate(nums1, 2);

    }
}
