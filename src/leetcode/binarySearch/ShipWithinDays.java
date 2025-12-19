package leetcode.binarySearch;

import java.util.Arrays;

public class ShipWithinDays {
    private boolean possible(int[] weights, int capacity, int days){
        int dayCount = 1;
        int currentLoad = 0;
        for(int w: weights){
            if(currentLoad + w <= capacity){
                currentLoad += w;
            } else {
                dayCount++;
                currentLoad = w;
            }
        }
        return dayCount <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = Arrays.stream(weights).max().orElseThrow();
        int maxWeight = Arrays.stream(weights).sum();
        while (maxWeight > minWeight){
            int mid = minWeight + (maxWeight - minWeight)/2;
            boolean isPossible = possible(weights, mid, days);
            if(isPossible){
                maxWeight = mid;
            }else {
                minWeight = mid + 1;
            }
        }
        return minWeight;
    };
    public static void main(String[] args) {
        int [] weights = {3,2,2,4,1,4};
        int days = 3;
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        System.out.println(shipWithinDays.shipWithinDays(weights, days));
    }
}
