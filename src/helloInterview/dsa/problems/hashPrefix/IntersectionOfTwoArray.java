package helloInterview.dsa.problems.hashPrefix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num: nums1){
            set.add(num);
        }
        for(int num: nums2){
            if(set.contains(num)){
                res.add(num);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
    public static void main(String[] args) {
        IntersectionOfTwoArray intersection = new IntersectionOfTwoArray();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection.intersection(nums1, nums2)));
    }
}
