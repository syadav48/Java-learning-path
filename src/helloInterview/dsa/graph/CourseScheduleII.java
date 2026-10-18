package helloInterview.dsa.graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] prereq: prerequisites){
            int src = prereq[1], dest = prereq[0];
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            indegree[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            int course = queue.poll();
            res.add(course);
            for(int neighbour: adjList.getOrDefault(course, new ArrayList<>())){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) queue.offer(neighbour);
            }
        }
        if (res.size() != numCourses) {
            return new int[0]; // empty array if not all courses can be finished
        }

        return res.stream().mapToInt(x -> x).toArray();

    }
    public static void main(String[] args) {
        CourseScheduleII scheduleII = new CourseScheduleII();
        int[][] prereq = {
                {1,0},{2,0},{3,1},{3,2}
        };
        System.out.println(Arrays.toString(scheduleII.findOrder(4, prereq)));
    }
}
