package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetCommon {
    public int getCommon(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
              int res = Arrays.binarySearch(nums2, nums1[i]);
              if(res >= 0){
                  list.add(res);
              }
        }
        return !list.isEmpty() ? nums2[list.getFirst()] : -1;
    }
    public static void main(String[] args) {
        GetCommon getCommon = new GetCommon();
        int [] nums1 = {1,2,3};
        int [] nums2 = {2,4};
        System.out.println(getCommon.getCommon(nums1, nums2));
    }
}
