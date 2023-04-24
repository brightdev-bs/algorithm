package review;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_5 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    public int solution(int[][] board, int[] s, int[] e){
        int answer = 0;

        int n = board.length;
        int m = board[0].length;
        int[][] ch = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(ch[i], Integer.MAX_VALUE);
        }
        ch[s[0]][s[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{s[0], s[1], 0}); // r, c, 이동 횟수
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int r = tmp[0];
            int c = tmp[1];
            int v = tmp[2];
            if(ch[r][c] < v) continue;
            for(int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                int nv = v;
                while(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 0) {
                    nr = nr + dr[i];
                    nc = nc + dc[i];
                    nv++;
                }
                nr = nr - dr[i];
                nc = nc - dc[i];
                nv--;
                if(ch[nr][nc] > nv) {
                    ch[nr][nc] = nv;
                    pq.add(new int[]{nr, nc, nv});
                }
            }
        }

        if(ch[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
        else return ch[e[0]][e[1]];
    }
    public static void main(String[] args){
        Q8_5 T = new Q8_5();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
