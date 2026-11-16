package helloInterview.dsa.problems.searchSorting;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
           else if (nums[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert.searchInsert(nums, target));
    }
}
