package helloInterview.dsa.dp;

public class PartitionSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        // equal subset requires an even total sum
        if(totalSum % 2 != 0){
            return false;
        }
        int target = totalSum/2;
        boolean[] dp = new boolean[target + 1];
        // A sum of zero is always achievable: choose no elements.
        dp[0] = true;
        for (int num : nums) {
            // Traverse backward: use each element at most once.
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }

            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        PartitionSum partitionSum = new PartitionSum();
        int[] nums = {1,5,11,5};
        System.out.println(partitionSum.canPartition(nums));
    }
}
