package bfs.inflearn.important;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_2 {

    int[][] ch;

    public int solution(int[] pool, int a, int b, int home){
        ch = new int[100001][2];
        for (int i : pool) {
            ch[i][0] = 1;
            ch[i][1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[] current = queue.poll();

                int pos = current[0];
                int nPos = pos + a;
                int bPos = pos - b;

                if(nPos == home || bPos == home) return L + 1;

                if(current[1] == 0) {
                    if(nPos <= 100000 && ch[nPos][0] == 0) {
                        ch[nPos][0] = 1;
                        queue.add(new int[]{nPos, 0});
                    }

                    if(bPos >= 0 && ch[bPos][1] == 0) {
                        ch[bPos][1] = 1;
                        queue.add(new int[]{bPos, 1});
                    }
                }

                // 이전에 뒤로 온 경우
                else if(current[1] == 1) {
                    if(nPos <= 100000 && ch[nPos][0] == 0) {
                        ch[nPos][0] = 1;
                        queue.add(new int[]{nPos, 0});
                    }
                }

            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Q7_2 T = new Q7_2();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
