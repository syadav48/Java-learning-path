package helloInterview.dsa.graph;

import java.util.Arrays;

public class DSUCycleDetection {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
                {0,1},{1,2},{2,3},{3,0}
        };
        DSU dsu = new DSU(n);
        boolean hasCycle = false;
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                hasCycle = true;
                break;
            }
        }
        System.out.println("Cycle detected? " + hasCycle);

    }
}
