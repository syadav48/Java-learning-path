package helloInterview.dsa.problems.hashPrefix;

import java.util.*;

public class FindDiff {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num: nums1){
            if(Arrays.binarySearch(nums2, num) < 0 && !list1.contains(num)){
                list1.add(num);
            }
        }
        res.add(list1);
        for (int num: nums2){
            if(Arrays.binarySearch(nums1, num) < 0 && !list2.contains(num)){
                list2.add(num);
            }
        }
        res.add(list2);
        return res;
    }
    public List<List<Integer>> findDifferenceOpt(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num: nums1){
            set2.add(num);
        }
        for(int num: nums2){
            set.add(num);
        }
        for(int num: nums1){
            if(!set.contains(num) && !list1.contains(num)){
                list1.add(num);
            }
        }
        for(int num: nums2){
            if(!set2.contains(num) && !list2.contains(num)){
                list2.add(num);
            }
        }
        res.add(list1);
        res.add(list2);
        return res;
    }

    public List<List<Integer>> findDifferenceMostOpt(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        return List.of(list1, list2);
    }

    public static void main(String[] args) {
        FindDiff findDiff = new FindDiff();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        int[] nums3 = {1,2,3,3};
        int[] nums4 = {1,1,2,2};
        System.out.println(findDiff.findDifferenceOpt(nums1, nums2));
        System.out.println(findDiff.findDifferenceOpt(nums3, nums4));
    }
}
