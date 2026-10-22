package helloInterview.dsa.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    public int primMST(int V, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] visited = new boolean[V];
        pq.offer(new int[]{0,0});
        int mstCost = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            mstCost += wt;
            for(int[] nei : adj.get(node)) {
                int adjNode = nei[0];
                int edgeWt = nei[1];
                if(!visited[adjNode]) {
                    pq.offer(
                            new int[]{edgeWt, adjNode}
                    );
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1,2},
                {0,2,3},
                {1,3,4},
                {2,1,3}
        };
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        Prims prims = new Prims();
        System.out.println(prims.primMST(4, adj));
    }
}
