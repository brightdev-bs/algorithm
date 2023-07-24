package leetcode.reivew.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalSecondTime {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            for(int i = 0; i < intervals.length; i++) {
                if(newInterval[1] < intervals[i][0]) {
                    res.add(new int[] {newInterval[0], newInterval[1]});
                    for(int j = i; j < intervals.length; j++) {
                        res.add(intervals[j]);
                    }
                    return toArray(res);
                } else if(intervals[i][1] < newInterval[0]) {
                    res.add(new int[] {intervals[i][0], intervals[i][1]});
                } else { // 겹치는 경우
                    int left = Math.min(intervals[i][0], newInterval[0]);
                    int right = Math.max(intervals[i][1], newInterval[1]);
                    newInterval = new int[] {left, right};
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
}
