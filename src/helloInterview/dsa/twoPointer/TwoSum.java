package helloInterview.dsa.twoPointer;

public class TwoSum {
    public boolean twoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,8,10,13};
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(nums, 6));
    }
}
