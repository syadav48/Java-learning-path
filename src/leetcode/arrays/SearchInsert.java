package leetcode.arrays;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       while (left <= right){
           int mid = left + (right - left) / 2;
           System.out.println(mid + " " + left + " " + right);
           if(nums[mid] == target){
               return mid;
           } else if(nums[mid] < target){
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
       return left;
    };
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8, 9, 11, 13, 16, 18};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
