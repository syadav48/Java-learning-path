package leetcode.ElitePattern.arrays.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        Iterator<Integer> iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            makeRowZero(matrix, iterator1.next());
        }
        Iterator<Integer> iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            makeColumnZero(matrix, iterator2.next());
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    private void makeColumnZero(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    private void makeRowZero(int[][] matrix, int i) {
        Arrays.fill(matrix[i], 0);
    }

    public void advancedSetZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row & column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero rows
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        // Zero columns
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }

        // Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes.setZeroes(matrix);
    }
}
