package helloInterview.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        dfs(source, graph, visited);
        return visited[destination];
    }

    public void dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        for (int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, graph, visited);
            }
        }
    }
    public static void main(String[] args) {
        PathExist pathExist = new PathExist();
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int[][] edges1 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(pathExist.validPath(n, edges, 0, 2));
        System.out.println(pathExist.validPath(6, edges1, 0, 5));
    }
}
