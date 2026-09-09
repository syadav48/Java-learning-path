package helloInterview.dsa.binarySearch;

public class SearchInRotatedSubArr {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
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
        SearchInRotatedSubArr subArr = new SearchInRotatedSubArr();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(subArr.search(nums, target));
    }
}
