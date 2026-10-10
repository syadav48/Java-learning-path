package helloInterview.dsa.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][points[0].length];
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for(int[] point: points){
            int calDist = calculateDistance(point);
            pq.offer(new int[]{point[0], point[1], calDist});
            if(pq.size() > k){
                pq.poll();
            }
        };
        while (!pq.isEmpty()){
            int[] pr = pq.poll();
            res[i++] = new int[]{pr[0], pr[1]};
        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }

    private int calculateDistance(int[] point) {
        int x = point[0]*point[0];
        int y = point[1]*point[1];
        return x + y;
    }


    public int[][] kClosestOpt(int[][] points, int k) {
        int[][] res = new int[k][points[0].length];
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(calculateDistance(b), calculateDistance(a)));
        for(int[] point: points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        };
        while (!pq.isEmpty()){
            res[i++] = pq.poll();
        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }

    public static void main(String[] args) {
        KClosestPoints kClosestPoints = new KClosestPoints();
        int[][] points = {{3,3}, {5, -1}, {-2, 4}};
        kClosestPoints.kClosest(points, 2);
    }
}
