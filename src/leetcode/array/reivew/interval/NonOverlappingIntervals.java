package leetcode.array.reivew.interval;

import java.util.Arrays;
// easy
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cur = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= cur) {
                cur = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
