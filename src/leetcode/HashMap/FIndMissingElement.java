package leetcode.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndMissingElement {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int lowest = nums[0];
        int highest = nums[nums.length - 1];
        List<Integer> list = new ArrayList<>();
        for(int i = lowest; i < highest; i++){
            int i1 = Arrays.binarySearch(nums, i);
            System.out.println(i1);
            if(i1 < 0){
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums = {5,1};
        FIndMissingElement fIndMissingElement = new FIndMissingElement();
        System.out.println(fIndMissingElement.findMissingElements(nums));
    }
}
