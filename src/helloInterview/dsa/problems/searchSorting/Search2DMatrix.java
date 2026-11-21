package helloInterview.dsa.problems.searchSorting;

import java.util.Arrays;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row = rowFinder(matrix, target);
        if(row == null){
            return false;
        }
        return numFinder(row, target);
    }
    private int[] rowFinder(int[][] matrix, int target){
        int left = 0;
        int right = matrix.length - 1;
        int n = matrix[0].length - 1;
        while (right >= left){
            int mid = left + (right - left)/2;
            if(matrix[mid][0] <= target && matrix[mid][n] >= target){
                return matrix[mid];
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    };
    private boolean numFinder(int[] matrix, int target){
        int left = 0;
        int right = matrix.length - 1;
        while (right >= left){
            int mid = left + (right - left)/2;
            if(matrix[mid] < target){
                left = mid + 1;
            } else if (matrix[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    };
    public boolean searchMatrixOpt(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols - 1;

        while (right >= left){
            int mid = left + (right - left)/2;
            int val = matrix[mid / cols][mid % cols];
            if(val == target){
                return true;
            } else if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix1 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target1 = 13;
        int target = 3;
        System.out.println(search2DMatrix.searchMatrixOpt(matrix, target));
        System.out.println(search2DMatrix.searchMatrixOpt(matrix1, target1));
    }
}
