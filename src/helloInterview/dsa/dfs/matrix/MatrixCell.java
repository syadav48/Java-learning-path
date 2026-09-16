package helloInterview.dsa.dfs.matrix;

import java.util.HashSet;
import java.util.Set;

public class MatrixCell {
    public void dfs(int[][] matrix){
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<String> visited = new HashSet<>();
        dfsHelper(0, 0, matrix, visited, directions);
    }

    private void dfsHelper(int r, int c, int[][] matrix, Set<String> visited, int[][] directions) {
        String key = r + "," + c;
        if(visited.contains(key)){
            return;
        }
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix.length){
            return;
        }
        visited.add(key);
        for(int[] dir: directions){
            dfsHelper(r + dir[0], c + dir[1], matrix, visited, directions);
        }
        return;
    }

    public static void main(String[] args) {
        MatrixCell matrixCell = new MatrixCell();
        int[][] matrix = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        matrixCell.dfs(matrix);
    }
}
