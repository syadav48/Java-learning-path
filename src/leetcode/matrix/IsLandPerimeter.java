package leetcode.matrix;

public class IsLandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    perimeter += 4;
                    if(i < row - 1 && grid[i+1][j] == 1) perimeter--;
                    if(j < col - 1 && grid[i][j+1] == 1) perimeter--;
                    if(i > 0 && grid[i-1][j] == 1) perimeter--;
                    if(j > 0 && grid[i][j-1] == 1) perimeter--;
                }
            }
        }
        return perimeter;
    }
    public static void main(String[] args) {
        IsLandPerimeter isLandPerimeter = new IsLandPerimeter();
        int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(isLandPerimeter.islandPerimeter(grid));
    }
}
