package helloInterview.dsa.graph.basicAlgo;

import java.util.List;

public class Cycle {
    public boolean hasCycle(List<List<Integer>> graph){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
               if (dfs(graph, i, visited, -1)) return true;
            }
        }
        return false;
    }
    private boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, int parent){
        visited[node] = true;
        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                if(dfs(graph, neighbour, visited, node)){
                    return true;
                }
            } else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
    public static boolean hasCycleDirected(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfsDirected(graph, i, visited, recStack)) return true;
            }
        }
        return false;
    }
    public static boolean dfsDirected(List<List<Integer>> graph, int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour] && dfsDirected(graph, neighbour, visited, recStack)) {
                return true;
            } else if (recStack[neighbour]) {
                return true; // back edge → cycle
            }
        }

        recStack[node] = false;
        return false;
    }
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        List<List<Integer>> graph = List.of(
                List.of(1, 2),
                List.of(0, 2),
                List.of(0, 1)
        );
        List<List<Integer>> graph1 = List.of(
                List.of(1),
                List.of(2),
                List.of(0)
        );
        List<List<Integer>> graph2 = List.of(
                List.of(1, 2),
                List.of(3),
                List.of(3),
                List.of()
        );
        System.out.println(cycle.hasCycle(graph));
        System.out.println(cycle.hasCycleDirected(graph1));
        System.out.println(cycle.hasCycleDirected(graph2));
    }
}
