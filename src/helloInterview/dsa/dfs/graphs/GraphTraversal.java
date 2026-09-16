package helloInterview.dsa.dfs.graphs;

import java.util.*;

public class GraphTraversal {
    private Set<Integer> visited;

    public void dfs(Map<Integer, List<Integer>> adjList) {
        if (adjList == null || adjList.isEmpty()) {
            return;
        }
        visited = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfsHelper(node, adjList);
            }
        }
    }

    private void dfsHelper(int node, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);

        for (int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
            dfsHelper(neighbour, adjList);
        }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 2));
        adjList.put(1, Arrays.asList(3));
        adjList.put(2, Arrays.asList(3));
        adjList.put(3, Arrays.asList());

        GraphTraversal gt = new GraphTraversal();
        gt.dfs(adjList);
    }

}

