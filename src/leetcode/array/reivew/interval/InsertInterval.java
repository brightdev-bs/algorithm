package leetcode.array.reivew.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for(int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);

                }
                return toArray(res);
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                int min = Math.min(newInterval[0], intervals[i][0]);
                int max = Math.max(newInterval[1], intervals[i][1]);
                newInterval = new int[]{min, max};
            }
        }
        res.add(newInterval);

        return toArray(res);
    }

    private static int[][] toArray(List<int[]> res) {
        int[][] answer = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}
