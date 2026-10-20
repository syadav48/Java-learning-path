package helloInterview.dsa.graph.notes;

import helloInterview.dsa.graph.DSU;

public class CycleDSU {
    public boolean detectCycle(int n, int[][] edges){
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            if(!dsu.union(edge[0], edge[1])){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
                {0,1},{1,2},{2,3},{3,0}
        };
        CycleDSU cycleDSU = new CycleDSU();
        System.out.println(cycleDSU.detectCycle(n, edges));
    }
}
