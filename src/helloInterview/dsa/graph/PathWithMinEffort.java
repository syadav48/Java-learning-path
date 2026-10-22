package helloInterview.dsa.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for(int[] row: effort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        effort[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int currEffort = curr[2];
            if(r == m - 1 && c == n - 1){
                return currEffort;
            }
            if(currEffort > effort[r][c]){
                continue;
            }
            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }
                int edgeWeight =
                        Math.abs(
                                heights[r][c] -
                                        heights[nr][nc]
                        );
                int newEffort =
                        Math.max(currEffort,
                                edgeWeight);
                if(newEffort < effort[nr][nc]) {

                    effort[nr][nc] =
                            newEffort;

                    pq.offer(
                            new int[]{
                                    nr,
                                    nc,
                                    newEffort
                            }
                    );
                }
            }
        }
        return 0;

    }
    public static void main(String[] args) {
        PathWithMinEffort path = new PathWithMinEffort();
        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(path.minimumEffortPath(heights));
    }
}
