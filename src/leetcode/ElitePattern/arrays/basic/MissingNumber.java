package leetcode.ElitePattern.arrays.basic;

 public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            result ^= i;
        }
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int [] nums = {3, 0, 1};
        System.out.println(missingNumber.missingNumber(nums));
    }
}
