package implementation.inflearn;

import java.util.Arrays;

public class Q1_8 {

    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        for(int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }

        int[] enterIdx = new int[n];
        for(int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }

        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int t = 0;
        // i = exit 인덱스, j = enter 인덱스
        for(int i = 0, j = 0; i < n; i++) {
            int target = enterIdx[exit[i]];

            while(j < n && j <= target) {
                enterT[enter[j]] = t++;
                j++;
            }
            exitT[exit[i]] = t++;
        }

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if (!(enterT[i] > exitT[j] || enterT[j] > exitT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q1_8 T = new Q1_8();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
