package graph.inflearn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_4 {

    int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};

    public int solution(int[][] board) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        int[][] ch = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(ch[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        ch[0][0] = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int v = cur[2];

            if(ch[r][c] < v) continue;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || n <= nr || nc < 0 || m <= nc) continue;

                if(board[r][c] - 1 == i && ch[nr][nc] > v) {
                    pq.add(new int[]{nr, nc, v});
                    ch[nr][nc] = v;
                    continue;
                }
                if(board[r][c] - 1 != i && ch[nr][nc] > v + 1) {
                    pq.add(new int[]{nr, nc, v + 1});
                    ch[nr][nc] = v + 1;
                }
            }
        }

        answer = ch[n - 1][m - 1];
        return answer;
    }

    public static void main(String[] args){
        Q8_4 T = new Q8_4();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
