package helloInterview.dsa.problems.searchSorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindPickElem {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left){
            int mid = left + (right - left)/2;
            // going downhill
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            } else {
                // going uphill
                left = mid + 1;
            }
        }

        return left;
    }
    public static void main(String[] args) {
        FindPickElem findPickElem = new FindPickElem();
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        // 3
        System.out.println(findPickElem.findPeakElement(nums));
    }
}
