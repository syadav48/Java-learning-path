package leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums1.length; i++) {
            if(i >= m && nums1[i] == 0){
                nums1[i] = nums2[i - m];
            }
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int m = 6;
        int[] nums2 = {1,2,2};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
}
