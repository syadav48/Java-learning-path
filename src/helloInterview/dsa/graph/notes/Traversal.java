package helloInterview.dsa.graph.notes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {
    public static void bfs(List<List<Integer>> graph, int start){
        int n = graph.size();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                list.add(node);
                for(int neighbour: graph.get(node)){
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            result.add(list);
        }
        System.out.println(result);

    }

    public static void bfsTraverse(List<List<Integer>> graph, int start){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + " ");
            for (int neighbour : graph.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void dfsTraverse(List<List<Integer>> graph, int node, boolean[] visited){
        visited[node] = true;
        System.out.println(node + " ");
        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                dfsTraverse(graph, neighbour, visited);
            }
        }
    }

    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited, int depth, List<List<Integer>> result){
        visited[node] = true;

        // Ensure result has a list for this depth
        if(result.size() <= depth){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node);

        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                dfs(graph, neighbour, visited, depth + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
                List.of(1,2,3),
                List.of(0, 3),
                List.of(0,5),
                List.of(0,1,4),
                List.of(3,5),
                List.of(2,4)
        );
        List<List<Integer>> graph1 = List.of(
                List.of(1,2),   // 0
                List.of(3,4),   // 1
                List.of(5,6),   // 2
                List.of(),      // 3
                List.of(),      // 4
                List.of(),      // 5
                List.of()       // 6
        );

        int start = 0;
        bfs(graph, start);
        bfsTraverse(graph, start);
        boolean[] visited = new boolean[graph1.size()];
        //dfsTraverse(graph, start, visited);
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph1, start, visited, 0, result);
        System.out.println(result);
    }
}
