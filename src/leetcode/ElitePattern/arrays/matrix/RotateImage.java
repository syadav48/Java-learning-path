package leetcode.ElitePattern.arrays.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateImage {
    
    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        for(int[] rows: result){
            int left = 0; int right = result.length - 1;
            while (left < right){
                int temp = rows[left];
                rows[left] = rows[right];
                rows[right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                matrix[i][j] = result[i][j];
            }
        }

    }
    public static void main(String[] args) {
       int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};  //{{1,4,7}, {2,5,8}, {3,6,9}}
        //int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);

    }
}
