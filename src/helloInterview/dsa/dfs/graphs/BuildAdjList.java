package helloInterview.dsa.dfs.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildAdjList {
    public static Map<Integer, List<Integer>> buildAdjList(int n, int[][] edges){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < n; i ++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
    public static void main(String[] args) {
        BuildAdjList buildAdjList = new BuildAdjList();
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        System.out.println(buildAdjList(n, edges));
    }
}
