package leetcode.sorting;

import java.util.Arrays;


public class LargestPerimeter {
    public LargestNumber largestNumber = new LargestNumber();
    public int largestPerimeter(int[] nums) {
       int d = largestNumber.dominantIndex(nums);
        System.out.println(d);
        Arrays.sort(nums);
        int a = 0;
        int b = 0;
        int c = 0;
        int i = nums.length - 1;
        while (i >= 2){
            if(nums[i-1] + nums[i-2] > nums[i]){
                a = nums[i];
                b = nums[i - 1];
                c = nums[i - 2];
                System.out.println(a + " " + b + " " + c);
                return a + b + c;
            }
            i--;
        }
       return 0;
    };
    public static void main(String[] args) {
        int[] nums1 = {2,1,2};
        int[] nums2 = {1,2,1,10};
        int[] nums3 = {3,6,2,3};
        LargestNumber largestNumber1 = new LargestNumber();
        System.out.println(largestNumber1.dominantIndex(nums3));
        LargestPerimeter largestPerimeter = new LargestPerimeter();
        System.out.println(largestPerimeter.largestPerimeter(nums1));
        System.out.println(largestPerimeter.largestPerimeter(nums2));
        System.out.println(largestPerimeter.largestPerimeter(nums3));
    }
}
