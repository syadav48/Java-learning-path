package helloInterview.dsa.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//Dijkstra almost always starts by converting the edge list into an adjacency list
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if(d > dist[u]){
                continue;
            }
            for(int[] neighbour: adj.get(u)){
                int v = neighbour[0];
                int wt = neighbour[1];
                if(d + wt < dist[v]){
                    dist[v] = d + wt;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime.networkDelayTime(times, n, k));
    }
}
