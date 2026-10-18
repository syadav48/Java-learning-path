package helloInterview.dsa.graph;

import java.util.*;

public class BuildGraph {
    // Build adjacency list
    public List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // remove this line if directed graph
        }
        for (int i = 0; i < graph.size(); i++) {
            map.put(i, graph.get(i));
        }
        System.out.println(map);
        return graph;
    }

    // Depth First Search
    public void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        System.out.print(node + " ");
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, graph);
            }
        }
    }

    // Breadth First Search
    public void bfs(int start, List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Check if graph is connected
    public boolean isConnected(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        dfs(0, visited, graph);
        for(boolean v : visited){
            if(!v) return false;
        }
        return true;
    }

    // Count connected components
    public int countConnectedComponents(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        int count = 0;
        for(int i = 0; i < graph.size(); i++){
            if(!visited[i]){
                dfs(i, visited, graph);
                count++;
            }
        }
        return count;
    }

    // Detect cycle in undirected graph
    public boolean hasCycle(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        for(int i = 0; i < graph.size(); i++){
            if(!visited[i]){
                if(detectCycleDFS(i, -1, visited, graph)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleDFS(int node, int parent, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(detectCycleDFS(neighbor, node, visited, graph)) return true;
            } else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
    public int[] calIndegree(int n, int[][] edges){
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }
        System.out.println(adjList);
        return indegree;
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
        System.out.println(Arrays.toString(buildGraph.calIndegree(n, edges)));
        List<List<Integer>> graph = buildGraph.buildGraph(n, edges);
        System.out.println("Adjacency List: " + graph);

        System.out.print("DFS Traversal: ");
        buildGraph.dfs(0, new boolean[n], graph);
        System.out.println();

        System.out.print("BFS Traversal: ");
        buildGraph.bfs(0, graph);
        System.out.println();

        System.out.println("Is Connected: " + buildGraph.isConnected(graph));
        System.out.println("Connected Components: " + buildGraph.countConnectedComponents(graph));
        System.out.println("Has Cycle: " + buildGraph.hasCycle(graph));
    }
}
