package leetcode.interval;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int last = intervals[0][1];
        int count = 1;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= last) {
                count++;
                last = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals m = new NonOverlappingIntervals();
//        System.out.println(m.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
//        System.out.println(m.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(m.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));

    }
}
