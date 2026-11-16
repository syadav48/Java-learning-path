package helloInterview.dsa.problems.searchSorting;

import java.util.Arrays;

public class FirstAndLast {
    private int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (right >= left){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                ans = mid;
                right = mid - 1; // keep searching left
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (right >= left){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                ans = mid;
                left = mid + 1; // keep searching right
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                findFirst(nums, target),
                findLast(nums, target)
        };
    }
    public static void main(String[] args) {
        FirstAndLast firstAndLast = new FirstAndLast();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(firstAndLast.searchRange(nums, target)));
    }
}
