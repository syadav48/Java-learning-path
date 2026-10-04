package helloInterview.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompleteComponent {
    public int countCompleteComponents(int n, int[][] edges) {
       // building an adjacency list:
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int completeCount = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[n]){
                List<Integer> nodes = new ArrayList<>();
                int edgeCount = dfsComp(i, adjList, visited, nodes);
                int k = nodes.size();
                edgeCount /= 2;
                if(edgeCount == (k*(k-1))/2){
                    completeCount++;
                }
            }
        }
        System.out.println(adjList);
        return completeCount;
    }

    private int dfsComp(int node, List<List<Integer>> adjList, boolean[] visited, List<Integer> nodes) {
        visited[node] = true;
        nodes.add(node);
        int edgeCount = adjList.get(node).size();
        for(int neighbour: adjList.get(node)){
            if(!visited[neighbour]){
                edgeCount += dfsComp(neighbour, adjList, visited, nodes);
            }
        }
        return edgeCount;
    }

    public static void main(String[] args) {
        CompleteComponent component = new CompleteComponent();
        int[][] edges1 = {
                {0,1},
                {0,2},
                {1,2},
                {3,4}
        };
        int[][] edges2 = {
                {0,1},
                {0,2},
                {1,2},
                {3,4},
                {3,5}
        };
        System.out.println(component.countCompleteComponents(6, edges1));
        //System.out.println(component.countCompleteComponents(6, edges2));
    }
}
