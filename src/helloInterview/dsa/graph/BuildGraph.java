package helloInterview.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class BuildGraph {
    public List<List<Integer>> buildGraph(int n, int[][] edges){
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

        return graph;
    }
    public static void main(String[] args) {
        BuildGraph buildGraph = new BuildGraph();
        int n = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };
        System.out.println(buildGraph.buildGraph(n, edges));
    }
}
