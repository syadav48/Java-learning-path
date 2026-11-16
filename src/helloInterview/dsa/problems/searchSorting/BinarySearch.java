package helloInterview.dsa.problems.searchSorting;

import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left){
            int mid = (right + left)/2;
            int num = nums[mid];
            if(num > target){
                right = mid - 1;
            } else if (num < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int[] nums1 = new int[]{-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println(binarySearch.search(nums, target));
        System.out.println(binarySearch.search(nums1, target2));
    }
}
