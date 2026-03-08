package Multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyOtherIndexes {
    public int[] multiplyOtherIndexes(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int res1 = 0;
            for (int j = 0; j < arr2.length; j++) {
                if(i != j){
                    res1 += arr1[i]*arr2[j];
                }
            }
            list.add(res1);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public static void main(String[] args) {
        MultiplyOtherIndexes multiplyOtherIndexes = new MultiplyOtherIndexes();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        // 1, 5, 6
        // 2 4, 6
        // 3 4, 5
        System.out.println(Arrays.toString(multiplyOtherIndexes.multiplyOtherIndexes(arr1, arr2)));
    }

}
