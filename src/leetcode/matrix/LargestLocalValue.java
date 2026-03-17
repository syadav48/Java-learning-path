package leetcode.matrix;

import java.util.Arrays;

public class LargestLocalValue {
    public int findLargest(int[][] ingrid){
        System.out.println(Arrays.deepToString(ingrid));
        return 0;

    }
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m-2][n-2];
        for (int i = 0; i < m-3; i++){
            for (int j = 0; j < n-3; j++) {
                int[][] ingrid = new int[3][3];
                for(int r = i; r < i+3; r++){
                    for(int c = j; c < j + 3; c++){
                        ingrid[r][c] = grid[r][c];
                    }
                    findLargest(ingrid);
                }

            }

        }
        return result;
    };
    public static void main(String[] args) {
        LargestLocalValue lcv = new LargestLocalValue();
        int[][] grid = {
                {9,9,8,1},
                {5,6,2,6},
                {8,2,6,4},
                {6,2,2,2}
        };
        System.out.println(Arrays.deepToString(lcv.largestLocal(grid)));
    }
}
