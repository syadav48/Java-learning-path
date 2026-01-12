package leetcode.sorting.algorithms;

import java.util.Arrays;
// strategy: moves larger element to right
// poor for nearly sorted elements
public class BubbleSort {
    public int[] bubbleSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    };
    public static void main(String[] args) {
        int[] nums = {7,4,3,1,0,5,9};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(nums)));
    }
}
