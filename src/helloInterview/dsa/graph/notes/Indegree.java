package helloInterview.dsa.graph.notes;

import java.util.*;

public class Indegree {
    public int[] calIndegree(int n, int[][] edges){
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }
        System.out.println(map);
        return indegree;
    }
    public static void main(String[] args) {
        Indegree indegree = new Indegree();
        int n = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };
        System.out.println(Arrays.toString(indegree.calIndegree(n, edges)));
    }
}
