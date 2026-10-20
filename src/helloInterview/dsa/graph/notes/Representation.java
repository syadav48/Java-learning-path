package helloInterview.dsa.graph.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Representation {
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
    public int[][] adjMatrix(int n, int[][] edges){
        int[][] matrix = new int[n][n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 5;
        int [][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {2,3},
                {3,4}
        };
        Representation representation = new Representation();
        List<List<Integer>> graph = representation.buildGraph(n, edges);
        System.out.println(graph);
        System.out.println(Arrays.deepToString(representation.adjMatrix(n, edges)));
    }
}
