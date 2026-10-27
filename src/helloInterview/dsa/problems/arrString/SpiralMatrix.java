package helloInterview.dsa.problems.arrString;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while (top <= down && left <= right){
            // left -> right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            // top -> bottom
            for (int i = top; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // right -> left
            if (top <= down) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[down][j]);
                }
                down--;
            }
            // bottom -> top
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }
}
