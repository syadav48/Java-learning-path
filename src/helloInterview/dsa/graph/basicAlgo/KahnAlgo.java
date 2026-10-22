package helloInterview.dsa.graph.basicAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Kahn's Algorithm is a BFS-based Topological Sort.
public class KahnAlgo {
    public List<Integer> kahnTopoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for(int u = 0; u < V; u++) {
            for(int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        // Push all indegree 0 nodes
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for(int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);

        KahnAlgo kahnAlgo = new KahnAlgo();
        System.out.println(kahnAlgo.kahnTopoSort(V, adj));
    }
}
