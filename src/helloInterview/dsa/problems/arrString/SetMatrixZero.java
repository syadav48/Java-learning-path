package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    zeroSetter(matrix, i, j);
                }
            }
        }
    }
    public void zeroSetter(int[][] matrix, int i, int j){
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k] = 0;
        }
        System.out.println(j);
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }

    public void setZeroesOpt(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstColZero = false;
        for (int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0){
                firstColZero = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Apply markers
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // Handle first column separately
            if (firstColZero) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setMatrixZero.setZeroesOpt(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
