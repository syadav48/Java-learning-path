package helloInterview.dsa.problems.slidingWindow;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double avg = 0.0;
        double minAvg = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            avg += nums[right];
            if(right - left + 1 == k){
                minAvg = Math.max(avg, minAvg);
                avg -= nums[left];
                left++;
            }
        }
        return minAvg/k;
    }
    public static void main(String[] args) {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage.findMaxAverage(nums, 4));
    }
}
