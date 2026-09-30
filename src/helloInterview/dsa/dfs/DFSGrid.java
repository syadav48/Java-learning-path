package helloInterview.dsa.dfs;

public class DFSGrid {
    public int islandPerimeter(int[][] grid) {
        return 0;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return image;
    }
    public static void main(String[] args) {
        DFSGrid dfsGrid = new DFSGrid();
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(dfsGrid.islandPerimeter(grid));
        System.out.println(dfsGrid.floodFill(grid, 1,2,3));
    }
}
