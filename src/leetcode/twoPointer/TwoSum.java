package leetcode.twoPointer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int [] arr,int sum){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (right > left){
            int add = arr[right] + arr[left];
            if(add == sum){
                return new int[]{left, right};
            } else if(add > sum){
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] arr = {1,4,7,8,5,9,2}; //1,2,4,5,7,8,9
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(arr, 8)));
    }
}
