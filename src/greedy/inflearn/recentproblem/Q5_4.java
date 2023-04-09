package greedy.inflearn.recentproblem;

import java.util.Arrays;

public class Q5_4 {

    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;

        int n = plantTime.length;

        int[][] plants = new int[n][2];
        for(int i = 0; i < n; i++) {
            int pT = plantTime[i];
            int gT = growTime[i];
            plants[i][0] = pT;
            plants[i][1] = gT;
        }

        Arrays.sort(plants, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

        int sT = 0;
        int eT = 0;
        for (int[] plant : plants) {
            sT += plant[0];
            eT = Math.max(sT + plant[1], eT);
        }

        answer = eT;

        return answer;
    }

    public static void main(String[] args){
        Q5_4 T = new Q5_4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
