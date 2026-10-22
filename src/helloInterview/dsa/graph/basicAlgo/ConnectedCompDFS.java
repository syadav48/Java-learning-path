package helloInterview.dsa.graph.basicAlgo;

import java.util.ArrayList;
import java.util.List;

public class ConnectedCompDFS {
    public static List<List<Integer>> findConnectedComp(List<List<Integer>> graph){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                List<Integer> component = new ArrayList<>();
                dfsComp(graph, i, visited, component);
                components.add(component);
            }
        }
        return components;
    }
    public static void dfsComp(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> component){
        visited[node] = true;
        component.add(node);
        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                dfsComp(graph, neighbour, visited,component);
            }
        }

    }
    public static void main(String[] args) {
        //ConnectedCompDFS compDFS = new ConnectedCompDFS();
        List<List<Integer>> graph = List.of(
                List.of(1),
                List.of(0, 2),
                List.of(1),
                List.of(4),
                List.of(3),
                List.of()
        );
        System.out.println(findConnectedComp(graph));
    }
}
