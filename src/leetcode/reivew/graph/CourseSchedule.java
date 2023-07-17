package leetcode.reivew.graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] ch = new int[numCourses];
        for(int[] req : prerequisites) {
            ch[req[1]]++;
            map.putIfAbsent(req[0], new ArrayList<>());
            map.get(req[0]).add(req[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(ch[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            Integer index = queue.poll();
            if(map.get(index) == null) continue;
            for (Integer next : map.get(index)) {
                ch[next]--;
                if(ch[next] == 0) queue.add(next);
            }
        }

        for(int x : ch) {
            if( x != 0) return false;
        }
        return true;
    }
}
