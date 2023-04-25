package review;

import java.util.Arrays;

public class Q5_3 {

    public int solution(int n, int[] nums){
        int answer = 0;

        int[][] lines = new int[n + 1][2];
        for(int i = 0; i <= n; i++) {
            int s = Math.max(0, i - nums[i]);
            int e = Math.min(n, i + nums[i]);
            lines[i][0] = s;
            lines[i][1] = e;
        }

        Arrays.sort(lines, (a, b) -> a[0] - b[0]); // 오름차순으로 정렬
        int s = 0, e = 0, i = 0;
        while(i < lines.length) {
            while(i < lines.length && lines[i][0] <= s) {
                e = Math.max(e, lines[i][1]);
                i++;
            }

            answer++;
            if(s == e) return -1;
            if(e == n) return answer;
            s = e;



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
