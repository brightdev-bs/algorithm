package leetcode.reivew.graph;

import java.util.*;

public class CourseSchedule2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] mem = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites) {
            mem[pre[0]]++;
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(mem[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int index = queue.poll();
            if(map.get(index) == null) continue;
            for(int next : map.get(index)) {
                mem[next]--;
                if(mem[next] == 0) queue.add(next);
            }
        }

        for(int n : mem) {
            if(n != 0) return false;
        }

        return true;
    }
}
