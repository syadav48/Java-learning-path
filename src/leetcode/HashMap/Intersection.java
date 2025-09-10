package leetcode.HashMap;

import java.util.*;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int num: nums1){
            map.put(num, true);
        }
        for(int num: nums2){
            if(map.containsKey(num)){
                set.add(num);
            }
        }
        return set.stream().mapToInt(x -> x).toArray();
    }
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection.intersection(nums1, nums2);
        System.out.println(res);
    }
}
