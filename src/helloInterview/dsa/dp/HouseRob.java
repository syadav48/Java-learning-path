package helloInterview.dsa.dp;

import java.util.Arrays;

public class HouseRob {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
    public int robs(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int take = dp[i - 2] + nums[i - 1];
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public int robOpt(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int prev = 0;
        int curr = nums[0];
        for (int i = 2 ; i <= nums.length; i++) {
            int take = prev + nums[i - 1];
            int skip = curr;
            int temp = curr;
            curr = Math.max(take, skip);
            prev = temp;
        }
        return curr;
    }
    public static void main(String[] args) {
        HouseRob houseRob = new HouseRob();
        int[] nums = {2,7,9,3,1};
        System.out.println(houseRob.rob(nums));
    }
}
