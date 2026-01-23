package leetcode.matrix;

import java.util.Arrays;

public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Transpose transpose = new Transpose();
        System.out.println(Arrays.deepToString(transpose.transpose(matrix)));
    }
}
