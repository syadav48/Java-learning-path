package helloInterview.dsa.slidingWindow;

public class FixedLengthSlidingWindow {
    public int fixedLengthSlidingWindow(int[] nums, int k) {
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        FixedLengthSlidingWindow window = new FixedLengthSlidingWindow();
        int[] nums = {1,2,3,4,4,6,6,7,-2,1};
        System.out.println(window.fixedLengthSlidingWindow(nums, 3));

    }
}
