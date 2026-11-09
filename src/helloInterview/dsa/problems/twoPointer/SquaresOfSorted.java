package helloInterview.dsa.problems.twoPointer;

import java.util.Arrays;

public class SquaresOfSorted {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i]*nums[i];
        }
        Arrays.sort(res);
        return res;
    }
    public int[] sortedSquaresOpt(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if(leftSquare > rightSquare){
                res[index--] = leftSquare;
                left++;
            } else {
                res[index--] = rightSquare;
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        SquaresOfSorted squares = new SquaresOfSorted();
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(squares.sortedSquaresOpt(nums)));
    }
}
