package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class RemoveElem {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if(nums[end] != val){
                nums[start++] = nums[end];
            }
        }
        System.out.println(Arrays.toString(nums));
        return start;

    }
    public static void main(String[] args) {
        RemoveElem removeElem = new RemoveElem();
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElem.removeElement(nums, 2));
    }
}
