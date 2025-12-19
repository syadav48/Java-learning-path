package leetcode.binarySearch;

import java.util.Arrays;
import java.util.Set;

public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        Search search = new Search();
        System.out.println(search.search(nums, target));
        System.out.println(Arrays.toString(args));
    }
}
