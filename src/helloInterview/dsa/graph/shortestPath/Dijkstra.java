package helloInterview.dsa.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;



public class Dijkstra {
    public int[] dijkstra(int V, List<List<Pair>> adj, int src){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist[src] = 0;
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;
            System.out.println("Pair:" + u + ": " + d);
            //if (d > dist[u]) continue;
            for (Pair neighbour: adj.get(u)){
                int v = neighbour.node;
                int wt = neighbour.dist;
                if(d + wt < dist[v]){
                    dist[v] = d + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {

        int V = 4;

        List<List<Pair>> adj = Arrays.asList(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        adj.get(0).add(new Pair(1, 4));
        adj.get(0).add(new Pair(2, 2));
        adj.get(1).add(new Pair(3, 3));
        adj.get(2).add(new Pair(3, 1));

        Dijkstra obj = new Dijkstra();

        int[] ans = obj.dijkstra(V, adj, 0);

        System.out.println(Arrays.toString(ans));
    }
}
