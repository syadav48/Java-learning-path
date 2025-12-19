package leetcode.binarySearch;

import java.util.Arrays;

public class MaxDistance {
    private boolean canPlace(int[] position, int m, int dist){
        int count = 1;
        int lastPlaced = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= dist) {
                count++;
                lastPlaced = position[i];
            }
            if (count == m) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlace(position, m, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left + " " + right);
        return answer;
    }
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maxDistance(position, m));
    }
}
