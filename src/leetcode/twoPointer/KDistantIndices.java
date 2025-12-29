package leetcode.twoPointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list1 = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key){
                list1.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < list1.size(); j++) {
                if(Math.abs(i - list1.get(j)) <= k){
                    System.out.println(i);
                    set.add(i);
                }
            }
        }
        return set.stream().sorted().toList();
    }
    public static void main(String[] args) {
        int [] arr = {3,4,9,1,3,9,5};
        KDistantIndices kDistantIndices = new KDistantIndices();
        System.out.println(kDistantIndices.findKDistantIndices(arr, 9, 1));

    }
}
