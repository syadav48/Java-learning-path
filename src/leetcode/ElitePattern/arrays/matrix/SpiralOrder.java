package leetcode.ElitePattern.arrays.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j++) {
                int accessedElement = matrix[i][j];
                if(i == 0 && i != j){
                    list.add(matrix[i][j]);
                } else if (j == matrix[i].length - 1 && i >= 0) {
                    list.add(matrix[i][j]);
                } else if (i == matrix.length - 1 && j >= 0) {
                    list.add(matrix[i][j]);
                } else if (j == 0 && i >= 0) {
                    list.add(matrix[i][j]);
                } else if (i == j && j >= 0 && i >= 0) {
                    list.add(matrix[i][j]);
                }
                list.add(accessedElement);
                System.out.println(accessedElement);
            }
        }
        return list;
    }
    public List<Integer> optimizedSpiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix == null && matrix.length == 0) return result;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {

            // left -> right
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;

            // top → bottom
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            // right → left
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.optimizedSpiralOrder(matrix));
    }
}
