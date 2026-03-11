package Interview;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InterviewMphasis {
    public int findSum(int[] nums){
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).sum();
    }
    public  int subArraySum(int[] nums){
        int left = 0;
        int right = nums.length;
        int max = Integer.MIN_VALUE;
        while (right > left){
            int[] array = Arrays.stream(nums).boxed().toList().subList(left, right).stream().mapToInt(x -> x).toArray();
            max = Math.max(max, findSum(array));
            System.out.println(max);
            left++;
            right--;
        }
        return max;
    }

    public int maxSubArray(int[] nums){
        int maxSumSofar = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSumSofar = Math.max(maxSumSofar, currSum);
            System.out.println(currSum + "  " + maxSumSofar + "  ");
        }
        return maxSumSofar;
    };
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // 6 - I am not sure how left and right increment and decrement??

        InterviewMphasis interviewMphasis = new InterviewMphasis();
        System.out.println(interviewMphasis.maxSubArray(nums));
    }
}
