package helloInterview.dsa2.twoPointer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int[] res = new int[2];
        int right = numbers.length - 1;
        while (left < right){
            int mid = numbers[left] + numbers[right];
            System.out.println(mid);
            if(mid == target){
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (mid > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbsers = {2,7,11,15};
        int[] numbsers1 = {2,3,4};
        twoSum.twoSum(numbsers, 9);
        twoSum.twoSum(numbsers1, 6);
    }
}
