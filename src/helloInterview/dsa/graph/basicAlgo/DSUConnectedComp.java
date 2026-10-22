package helloInterview.dsa.graph.basicAlgo;

import helloInterview.dsa.graph.DSU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DSUConnectedComp {
    public static List<List<Integer>> findConnectedCompDSU(int n, int[][] edges){
        DSU dsu = new DSU(n);

        // union all edge
        for(int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        Map<Integer, List<Integer>> componentsMap = new HashMap<>();
        System.out.println(dsu);
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            System.out.println(root + " : root : " + i);
            componentsMap.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        return new ArrayList<>(componentsMap.values());
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0,1}, {1,2},   // Component 1
                {3,4}           // Component 2
                // Node 5 is isolated
        };


        List<List<Integer>> components = findConnectedCompDSU(n, edges);
        System.out.println("Connected Components: " + components);

    }
}
