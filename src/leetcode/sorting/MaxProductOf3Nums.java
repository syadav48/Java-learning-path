package leetcode.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxProductOf3Nums {
    public static int maximumProduct(int[] nums) {
        List<Integer> positiveList = Arrays.stream(nums).boxed().filter(x -> x > 0)
                .sorted(Comparator.reverseOrder()).toList();
        List<Integer> negativeList = Arrays.stream(nums).boxed().filter(x -> x < 0)
                .sorted(Comparator.reverseOrder()).toList();
        int maxProduct = 1;
        int positiveProduct = positiveList.size() >= 3 ?
                positiveList.get(0) * positiveList.get(1) * positiveList.get(2) : Integer.MIN_VALUE;
        int negativeProduct = negativeList.size() >= 3 ?
                negativeList.get(0) * negativeList.get(1) * negativeList.get(2) : Integer.MIN_VALUE;
        int mixProduct = negativeList.get(0) * negativeList.get(1) * positiveList.get(0);
        System.out.println(positiveProduct + " " + negativeProduct);
       return 5;
    }
    public static void main(String[] args) {

        int[] nums1 = {-100,-98, -1, 2,3,4};
        int[] nums2 = {-1,-2,-3};
        int[] nums3 = {1,2,3,4};
        System.out.println(maximumProduct(nums1));
        System.out.println(maximumProduct(nums2));
        System.out.println(maximumProduct(nums3));
    }
}
