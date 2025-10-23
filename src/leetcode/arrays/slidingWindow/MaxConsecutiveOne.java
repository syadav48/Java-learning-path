package leetcode.arrays.slidingWindow;

public class MaxConsecutiveOne {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int length = 0;
        int i = 0;
        int maxLength = 0;
        while (i <= nums.length - 1){
            if(nums[i] == 1){
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 0;
            }
            i++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,1,0,1,1,1};
        int[] nums2 = {1,0,1,1,0,1};
        int[] nums3 = {1,0,1,1,0,1,0,1,1,0,1,1,0,};
        System.out.println(findMaxConsecutiveOnes(nums1));
        System.out.println(findMaxConsecutiveOnes(nums2));
        System.out.println(findMaxConsecutiveOnes(nums3));
    }
}
