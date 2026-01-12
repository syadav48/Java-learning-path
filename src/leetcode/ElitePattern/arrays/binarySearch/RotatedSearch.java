package leetcode.ElitePattern.arrays.binarySearch;

import java.util.Arrays;

public class RotatedSearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            };
            // left half is sorted
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right half is sorted
            else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        RotatedSearch rotatedSearch = new RotatedSearch();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println(rotatedSearch.search(nums, target));
    }
}
