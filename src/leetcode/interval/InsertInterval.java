package leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int idx = 0;

        while(idx < intervals.length) {
            if(intervals[idx][0] < newInterval[0]) {
                res.add(intervals[idx]);
                idx++;
            } else {
                break;
            }
        }

        if(res.size() == 0 || (newInterval[0] > res.get(res.size() -1)[1])) {
            res.add(newInterval);
        } else {
            int[] lastInterval = res.get(res.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }

        while(idx < intervals.length) {
            int[] lastInterval = res.get(res.size() -1);

            if(lastInterval[1] >= intervals[idx][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
            } else {
                res.add(intervals[idx]);
            }
            idx++;
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval m = new InsertInterval();
        System.out.println(Arrays.deepToString(m.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(m.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(m.insert(new int[][]{{1, 5}}, new int[]{2, 3})));
    }

}
