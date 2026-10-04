package helloInterview.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class SourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graphs) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsPaths(0, graphs, path, res);
        return res;
    }

    private void dfsPaths(int node, int[][] graphs, List<Integer> paths, List<List<Integer>> res) {
        paths.add(node);
        if(node == graphs.length - 1){
            res.add(new ArrayList<>(paths));
        } else {
            for(int neighbour: graphs[node]){
                dfsPaths(neighbour, graphs, paths, res);
            }
        }
        paths.remove(paths.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graphs = {{1,2}, {3}, {3}, {}}; // adjacency list
        SourceToTarget source = new SourceToTarget();
        System.out.println(source.allPathsSourceTarget(graphs));
    }
}
