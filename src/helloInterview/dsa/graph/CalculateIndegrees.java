package helloInterview.dsa.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Each node in a graph has an indegree, which is the number of incoming edges to that node.
public class CalculateIndegrees {
    // list of edges
    public int[] indegrees(int n, int[][] edges){
        int[] indegree = new int[n];
        for(int[] edge: edges){
            indegree[edge[1]] += 1;
        }
        System.out.println(Arrays.toString(indegree));
        return indegree;
    }
    public int[] indegreesal(int n, Map<Integer, List<Integer>> adjList){
        int[] indegree = new int[n];
        for(int u: adjList.keySet()){
           for(int v : adjList.get(u)){
            indegree[v] += 1;
           }
        }
        System.out.println(Arrays.toString(indegree));
        return indegree;
    }
    public static void main(String[] args) {
        CalculateIndegrees calculateIndegrees = new CalculateIndegrees();
        int[][] edges = {{0,1}, {1,2}, {1,3}, {3,2}, {3,4}};
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        listMap.put(0, List.of(1));
        listMap.put(1, List.of(2,3));
        listMap.put(2, List.of());
        listMap.put(3, List.of(2,4));
        listMap.put(4, List.of());
        calculateIndegrees.indegrees(5, edges);
        calculateIndegrees.indegreesal(5, listMap);
    }
}
