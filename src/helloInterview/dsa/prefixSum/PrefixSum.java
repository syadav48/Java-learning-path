package helloInterview.dsa.prefixSum;

import java.util.Arrays;

public class PrefixSum {
    public int[] prefixSums(int[] arr){
        int n = arr.length;
        int[] prefixs = new int[n + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefixs[i] = prefixs[i - 1] + arr[i - 1];
        }
        System.out.println(Arrays.toString(prefixs));
        return prefixs;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 8, -5, 0, 6};
        PrefixSum prefixSum = new PrefixSum();
        prefixSum.prefixSums(arr);
    }
}
