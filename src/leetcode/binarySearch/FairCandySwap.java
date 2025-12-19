package leetcode.binarySearch;

import java.util.Arrays;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int reqSum = (aliceSum + bobSum)/2;
        int [] res = new int[2];
        for (int i = 0; i < bobSizes.length; i++) {
            int swaps = reqSum - bobSizes[i];
            if(swaps > 0 && Arrays.binarySearch(aliceSizes, swaps) != -1){
                res[0] = swaps;

            }
        }
        System.out.println(Arrays.toString(bobSizes));
        for (int i = 0; i < aliceSizes.length; i++) {
            int swaps = reqSum - aliceSizes[i];
            if(swaps > 0 && Arrays.binarySearch(bobSizes, swaps) != -1){
                res[1] = swaps;
            }
        }

        return res;

    }

    public int[] optFairCandySwap(int[] aliceSizes, int[] bobSizes){
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int diff = (aliceSum - bobSum)/2;
        Arrays.sort(aliceSizes);
        for (int y: bobSizes){
            int x = y + diff;
            if(x > 0 && Arrays.binarySearch(aliceSizes, x) >= 0){
                return new int[]{x, y};
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] aliceSizes = {2};
        int[] bobSizes = {1,3};
        FairCandySwap fairCandySwap = new FairCandySwap();
        System.out.println(Arrays.toString(fairCandySwap.optFairCandySwap(aliceSizes, bobSizes)));
        //3
    }
}
