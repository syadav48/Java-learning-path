package helloInterview.dsa.problems.searchSorting;

public class FindMinRotatedSubArr {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        FindMinRotatedSubArr findMinRotatedSubArr = new FindMinRotatedSubArr();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[]{11, 13, 15, 17};
        System.out.println(findMinRotatedSubArr.findMin(nums));
        System.out.println(findMinRotatedSubArr.findMin(nums1));
        System.out.println(findMinRotatedSubArr.findMin(nums2));
    }
}
