package helloInterview.dsa.graph.mst;

import helloInterview.dsa.graph.DSU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public int kruskal(int V, List<Edge> edges) {
        Collections.sort(
                edges,
                (a, b) -> a.wt - b.wt
        );
        DSU dsu = new DSU(V);
        int cost = 0;
        for (Edge edge : edges) {
            if (dsu.find(edge.u) != dsu.find(edge.v)) {
                dsu.union(edge.u, edge.v);
                cost += edge.wt;
            }
        }
        return cost;
    }

    public static void main(String[] args) {

        Kruskal kruskal = new Kruskal();

        int V = 4;

        List<Edge> edges = new ArrayList<>(
                List.of(
                        new Edge(0, 1, 2),
                        new Edge(0, 2, 3),
                        new Edge(0, 3, 6),
                        new Edge(1, 2, 8),
                        new Edge(2, 3, 7)
                )
        );

        System.out.println(
                kruskal.kruskal(V, edges)
        );
    }
}
