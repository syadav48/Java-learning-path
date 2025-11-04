package leetcode.HeapPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargest {
    int[] nums;
    int k;
    List<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.k = k;
        list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
    }

    public int add(int val) {
        list.add(val);
        List<Integer> list1 = list.stream().sorted().toList();
        return list1.get(list1.size() - k);
    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = {7, 7, 7, 7, 8, 3};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(9));
    }
}
