package helloInterview.dsa.binarySearch;

import java.util.Arrays;

public class AppleHarvest {
    private int timeTaken(int[] piles, int h){
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + h - 1)/h;
        }

        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right){
            int mid = left + (right - left)/2;
            if(timeTaken(piles, mid) > h){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        AppleHarvest harvest = new AppleHarvest();
        int[] piles = {3,6,7,11}; // 27, 15, 10, 7
        int h = 8;
        System.out.println(harvest.minEatingSpeed(piles, h));
    }
}
