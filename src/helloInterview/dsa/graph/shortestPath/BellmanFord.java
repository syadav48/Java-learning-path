package helloInterview.dsa.graph.shortestPath;

import java.util.Arrays;

public class BellmanFord {
    public int[] bellManFord(int V, int[][] edges, int src){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < V; i++) {
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord();
        int[][] edges = {
                {0,1,4},
                {0,2,5},
                {1,2,-3},
                {2,3,4}
        };
        System.out.println(Arrays.toString(bellmanFord.bellManFord(4, edges, 0)));
    }
}
