package leetcode.arrays.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num: nums2){
            stack.add(num);
        }
        while (i < nums1.length - 1){
            int index = stack.search(nums1[i]);
            System.out.println(index);
            for (int j = nums2.length - index; j < nums2.length; j++) {
                if(nums2[j] > nums1[i]){
                    System.out.println(nums2[j] + "Sout");
                    list.add(nums2[j]);
                    break;
                }
            }
            i++;
            list.add(-1);
        }

        System.out.println(stack);
        return list.stream().mapToInt(Integer ::intValue).toArray();
    }

    public static int[] nextGreaterElementII(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j] == num){
                    index = j;
                    break;
                }
            }
            int nextGenerator = -1;
            for(int j = index + 1; j < nums2.length; j++){
                if(nums2[j] > num){
                    nextGenerator = nums2[j];
                    break;
                }
            }
            list.add(nextGenerator);
        }
        return list.stream().mapToInt(Integer ::intValue).toArray();
    }
    public static void main(String[] args) {
        int [] nums1 = {2, 4};
        int [] nums2 = {1, 2, 3, 4};
        //4 - 2
        //1 - 4
        // 2 - 1 + 2
        System.out.println(Arrays.toString(nextGreaterElementII(nums1, nums2)));
    }
}
