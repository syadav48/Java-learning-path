package leetcode.dynamicprogramming;

public class CanJump {
    public boolean canJump(int[] nums) {
        int m = nums.length;
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(nums));
    }
}
