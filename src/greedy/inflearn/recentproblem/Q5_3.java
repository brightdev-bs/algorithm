package greedy.inflearn.recentproblem;

import java.util.Arrays;
import java.util.Comparator;

public class Q5_3 {

    public int solution(int n, int[] nums){
        int answer = 0;

        int[][] range = new int[nums.length + 1][2];
        for(int i = 0; i <= n; i++) {
            range[i][0] = Math.max(0, i - nums[i]);
            range[i][1] = Math.min(n, i + nums[i]);
        }

        Arrays.sort(range, Comparator.comparingInt(a -> a[0]));

        int start = 0, end = 0, i = 0;
        while(i < range.length) {
            while(i < range.length && range[i][0] <= start) {
                end = Math.max(end, range[i][1]);
                i++;
            }
            answer++;
            if(end == n) return answer;
            if(start == end) return -1;
            start = end;
        }

        return answer;
    }

    public static void main(String[] args){
        Q5_3 T = new Q5_3();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
