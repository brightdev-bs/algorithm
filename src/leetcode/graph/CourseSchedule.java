package leetcode.graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ch = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites) {
            ch[pre[1]]++;
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
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

        for(int x: ch) {
            if(x != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule m = new CourseSchedule();
        System.out.println(m.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(m.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(m.canFinish(5, new int[][]{
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2},
        }));
    }
}
