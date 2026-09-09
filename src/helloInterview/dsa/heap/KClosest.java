package helloInterview.dsa.heap;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int[] point: points){
            int dist = point[0]*point[0] + point[1]*point[1];
            if(heap.size() < k){
                heap.offer(dist);
                list.add(point);
            } else if (dist < heap.peek()) {
                heap.poll();
                heap.offer(dist);
                list.add(point);
            }
        }
        for (int[] num: list){
            System.out.println(Arrays.toString(num));
        }
        System.out.println(list);

        return new int[][]{Arrays.stream(list.removeFirst()).toArray()};
    }

    public int[][] kClosestOpt(int[][] points, int k) {
        PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        for (int i = 0; i < points.length; i++) {
            long x = points[i][0];
            long y = points[i][1];
            long distance = x * x + y * y;
            if (heap.size() < k) {
                heap.offer(new long[]{distance, i});
            } else if (distance < heap.peek()[0]) {
                heap.poll();
                heap.offer(new long[]{distance, i});
            }
        }
        int[][] result = new int[k][];
        for (long[] p : heap) {
            result[--k] = points[(int) p[1]];
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    public static void main(String[] args) {
        KClosest kClosest = new KClosest();
        int[][] points = {{3,4}, {2,2}, {1,1}, {0,0}, {5,5}};
        kClosest.kClosestOpt(points, 3);
    }
}
