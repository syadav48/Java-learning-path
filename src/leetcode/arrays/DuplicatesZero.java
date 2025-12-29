package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicatesZero {
    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
               list.add(0);
               list.add(0);
            } else {
               list.add(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
    }
    public void optDuplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;

        // Step 1: Count zeros that can be duplicated
        for (int i = 0; i < n - zeros; i++) {
            if (arr[i] == 0) {
                if (i == n - zeros - 1) {
                    arr[n - 1] = 0; // edge case
                    n--;
                    break;
                }
                zeros++;
            }
        }

        // Step 2: Copy backwards
        int last = n - zeros - 1;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zeros] = 0;
                zeros--;
                arr[i + zeros] = 0;
            } else {
                arr[i + zeros] = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        DuplicatesZero duplicatesZero = new DuplicatesZero();
        int[] arr = {1,0,2,3,0,4,5,0}; //1,0,0,2,3,0,0,4
        duplicatesZero.duplicateZeros(arr);
    }
}
