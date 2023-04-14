package bfs.inflearn.important;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_3 {

    int[][] ch;

    public int solution(int s, int e){
        ch = new int[2][200001];

        int L = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        ch[0][s] = 1;
        int move = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for(int i = 0; i < len; i++) {
                Integer cur = queue.poll();
                int a = cur + 1;
                int b = cur - 1;
                int c = cur * 2;
                int turn = L % 2;
                if(a <= 200000 && ch[turn][a] == 0) {
                    ch[turn][a] = 1;
                    queue.add(a);
                }

                if(b >= 0 && ch[turn][b] == 0) {
                    ch[turn][b] = 1;
                    queue.add(b);
                }

                if(c <= 200000 && ch[turn][c] == 0) {
                    ch[turn][c] = 1;
                    queue.add(c);
                }
            }

            e += L;
            if(ch[L % 2][e] == 1) return L;
        }

        return -1;
    }

    public static void main(String[] args){
        Q7_3 T = new Q7_3();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
