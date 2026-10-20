package helloInterview.dsa.graph;

import java.util.Arrays;

public class FindRedundant {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!dsu.union(u, v)){
                return new int[]{u, v};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        FindRedundant findRedundant = new FindRedundant();
        int[][] edges = {
                {1,2},
                {2,3},
                {3,1}
        };
        System.out.println(Arrays.toString(findRedundant.findRedundantConnection(edges)));
    }
}
