package leetcode.arrays.slidingWindow;

public class MaxAvgSubArr {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = Integer.MIN_VALUE;
        int i = 0;
        while (i + k <= nums.length){
            int sumMax = 0;
                    for(int j = i; j < k+i; j++){
                        sumMax += nums[j];
                    }
            System.out.println(sumMax);
                    sum = Math.max(sum, sumMax);
                    i++;
        }
        double avg =  (double) sum / k;
        return avg;
    }
    public static double findmaxAvg(int [] nums, int k){
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // 2. Initialize maxSum with the first window
        int maxSum = windowSum;

        // 3. Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // add new element, remove old one
            maxSum = Math.max(maxSum, windowSum);
        }

        // 4. Return average
        return (double) maxSum / k;
    }
    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }
}
