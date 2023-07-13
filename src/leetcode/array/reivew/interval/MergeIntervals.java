package leetcode.array.reivew.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {

            int[] current = res.get(res.size() - 1);
            // merge
            if(intervals[i][0] <= current[1]) {
                int min = Math.min(current[0], intervals[i][0]);
                int max = Math.max(current[1], intervals[i][1]);
                res.set(res.size() - 1, new int[]{min, max});
            } else {
                res.add(intervals[i]);
            }
        }

        int size = res.size();
        int[][] answer = new int[size][2];
        for(int i = 0; i < size; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}

