package helloInterview.dsa.problems.twoPointer;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (right > left){
            if(numbers[left] + numbers[right] > target){
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(twoSumII.twoSum(numbers, 9)));
    }
}
