package helloInterview.dsa.graph;

import helloInterview.dsa.dfs.FindModes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> res = new ArrayList<>();
        // build indegree array:
        for(List<Integer> edge: edges){
            int from = edge.get(0);
            int to = edge.get(1);
            indegree[to]++; 
        }
        System.out.println(Arrays.toString(indegree));
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                res.add(i);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        FindSmallestSetOfVertices ofVertices = new FindSmallestSetOfVertices();
        int n = 6;

        List<Integer> edge1 = List.of(0,1);
        List<Integer> edge2 = List.of(0,2);
        List<Integer> edge3 = List.of(2,5);
        List<Integer> edge4 = List.of(3,4);
        List<Integer> edge5 = List.of(4,2);
        List<List<Integer>> edges = List.of(edge1, edge2, edge3, edge4, edge5);

        System.out.println(ofVertices.findSmallestSetOfVertices(n, edges));
    }
}
