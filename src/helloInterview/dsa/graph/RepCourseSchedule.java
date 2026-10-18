package helloInterview.dsa.graph;

import java.util.*;

public class RepCourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        // Build graph
        for(int[] pre: prerequisites){
            int dest = pre[0], src = pre[1];
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            indegree[dest]++;
        }
        System.out.println(Arrays.toString(indegree));
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int neighbour: adjList.getOrDefault(course, new ArrayList<>())){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) queue.offer(neighbour);
            }
        }
        System.out.println(adjList);
        return count == numCourses;
    }
    public static void main(String[] args) {
        RepCourseSchedule schedule = new RepCourseSchedule();
        int[][] prereq = {{1,0},{2,1}, {3,1}, {2, 3}};
        // 0 -> 1, 1 -> 2, 1 -> 3, 3 -> 2
        // indegree : 0-1,1-2,2-0,3-1
        System.out.println(schedule.canFinish(4, prereq));
    }
}
