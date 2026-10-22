package helloInterview.dsa.graph.shortestPath;

import java.util.Arrays;

public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] temp = cost.clone();
            for(int[] flight: flights){
                int u = flight[0];
                int v = flight[1];
                int wt = flight[2];
                if (cost[u] == Integer.MAX_VALUE) {
                    continue;
                }
                temp[v] = Math.min(
                        temp[v],
                        cost[u] + wt
                );
            }
            cost = temp;
        }
        System.out.println(Arrays.toString(cost));
        return cost[dst] == Integer.MAX_VALUE ? - 1 : cost[dst];

    }
    public static void main(String[] args) {
        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
        int n = 4;
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice.findCheapestPrice(n, flights, src, dst, k));
    }
}
