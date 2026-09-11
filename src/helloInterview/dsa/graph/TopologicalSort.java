package helloInterview.dsa.graph;

import java.util.*;

public class TopologicalSort {
    public List<Integer> topologicalSort(Map<Integer, List<Integer>> adjList, int n) {
        // calculate indegree of each node
        int[] indegree = new int[n];
        for (int u: adjList.keySet()){
            for (int v: adjList.get(u)){
                indegree[v]++;
            }
        }
        // enqueue nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int u: indegree){
            if(u == 0){
                queue.offer(u);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()){
            int u = queue.poll();
            order.add(u);

            for(int v: adjList.getOrDefault(u, new ArrayList<>())){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return order.size() == n ? order : new ArrayList<>();

    }
    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        listMap.put(0, List.of(1, 3));
        listMap.put(1, List.of(2));
        listMap.put(2, List.of());
        listMap.put(3, List.of(1,4, 5));
        listMap.put(4, List.of(5));
        listMap.put(5, List.of());
        System.out.println(topologicalSort.topologicalSort(listMap, 6));

    }
}
