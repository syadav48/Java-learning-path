package leetcode.sorting.algorithms;

import java.util.Arrays;
// is used for nearly sorted array
// strategy: moves all smaller element to the left
public class InsertionSort {
    public int[] insertionSort(int[] nums){
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {7,4,3,1,0,5,9};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.insertionSort(nums)));
    }
}
