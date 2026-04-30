package leetcode.prefixSum;

import java.util.Arrays;

public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int[] res = new int[gain.length + 1];
        res[0] = 0;
        for (int i = 0; i < gain.length; i++) {
            res[i+1] = gain[i] + res[i];
        }
        return Arrays.stream(res).max().getAsInt();
    }
    public static void main(String[] args) {
        LargestAltitude largestAltitude = new LargestAltitude();
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude.largestAltitude(gain));
    }
}
