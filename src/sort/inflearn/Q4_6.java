package sort.inflearn;

import java.util.Arrays;

public class Q4_6 {

    public int solution(int[] tasks, long k) {
        int n = tasks.length;

        int[] sT = new int[n + 1];
        System.arraycopy(tasks, 0, sT, 1, n);
        Arrays.sort(sT);

        int rest = tasks.length;
        for(int i = 1; i <= n; i++) {
            long time = ((long)(sT[i] - sT[i - 1]) * rest);
            if(k < time) {
                long idx = k % rest;
                int cnt = 0;
                for(int j = 0; j < n; j++) {
                    if(tasks[j] >= sT[i]) {
                        if(cnt == idx) return j + 1;
                        cnt++;
                    }

                }
            } else {
                rest--;
                k -= time;
            }
        }


        return -1;
    }

    public static void main(String[] args){
        Q4_6 T = new Q4_6();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }


}
