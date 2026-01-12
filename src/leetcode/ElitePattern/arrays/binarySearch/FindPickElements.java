package leetcode.ElitePattern.arrays.binarySearch;

public class FindPickElements {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
        FindPickElements findPickElements = new FindPickElements();
        System.out.println(findPickElements.findPeakElement(nums));
    }
}
