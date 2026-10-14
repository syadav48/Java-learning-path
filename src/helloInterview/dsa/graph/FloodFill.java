package helloInterview.dsa.graph;

import java.util.Arrays;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor != color){
            dfs(image, sr, sc, color, originalColor);
        }
        System.out.println(Arrays.deepToString(image));
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int originalColor) {
        int r = image.length;
        int c = image[0].length;
        if(sr < 0 || sc < 0 || sr >= r || sc >= c) return;
        if(image[sr][sc] != originalColor) return;

        image[sr][sc] = newColor;
        dfs(image, sr+1, sc, newColor, originalColor);
        dfs(image, sr-1, sc, newColor, originalColor);
        dfs(image, sr, sc+1, newColor, originalColor);
        dfs(image, sr, sc-1, newColor, originalColor);
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill.floodFill(image,1,1,2);
    }
}
