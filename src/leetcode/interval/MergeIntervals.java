package leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        list.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] arr = list.get(list.size() - 1);

            // merge 하는 경우
            if(arr[0] <= intervals[i][0] && arr[1] >= intervals[i][0]) {
                list.remove(list.size() - 1);
                list.add(new int[]{Math.min(arr[0], intervals[i][0]), Math.max(arr[1], intervals[i][1])});
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {4, 5}})));
    }
}
