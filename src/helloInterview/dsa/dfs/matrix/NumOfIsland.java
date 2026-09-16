package helloInterview.dsa.dfs.matrix;

public class NumOfIsland {
    public int numIslands(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    count++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int r, int c, int rows, int cols) {
        grid[r][c] = 0;
        if(r + 1 < rows && grid[r+1][c] == 1){
            dfs(grid, r+1, c, rows,cols);
        }
        if (r > 0 && grid[r - 1][c] == 1) {
            dfs(grid, r - 1, c, rows, cols);
        }
        if (c + 1 < cols && grid[r][c + 1] == 1) {
            dfs(grid, r, c + 1, rows, cols);
        }
        if (c > 0 && grid[r][c - 1] == 1) {
            dfs(grid, r, c - 1, rows, cols);
        }
        return;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 0}
        };
        NumOfIsland numOfIsland = new NumOfIsland();
        System.out.println(numOfIsland.numIslands(grid));
    };

}




