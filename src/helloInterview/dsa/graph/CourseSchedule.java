package helloInterview.dsa.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] prereq: prerequisites){
            int dest = prereq[0];
            int src = prereq[1];
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            indegrees[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int neighbour: graph.getOrDefault(course, new ArrayList<>())){
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println(Arrays.toString(indegrees));
        return count == numCourses;
    }
        public static void main(String[] args) {
            CourseSchedule schedule = new CourseSchedule();
            int numCourses = 4;
            int[][] prerequisites = {{1,0},{2,1}, {3,1}, {2, 3}};
            System.out.println(schedule.canFinish(numCourses, prerequisites));
        }
}
