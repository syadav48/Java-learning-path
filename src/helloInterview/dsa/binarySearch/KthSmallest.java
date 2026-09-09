package helloInterview.dsa.binarySearch;

import java.util.Arrays;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int[] array = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sorted().toArray();
        return array[k-1];
    }
    public int kthSmallestOpt(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rows - 1][columns - 1];
        while (low < high){
            int mid = low + (high - low)/2;
            int count = countLessThanOrEqual(matrix, mid);
            if(count < k){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countLessThanOrEqual(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < cols){
            if(matrix[row][col] <= target){
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        int k = 8;
        System.out.println(kthSmallest.kthSmallestOpt(matrix, k));
    }
}
