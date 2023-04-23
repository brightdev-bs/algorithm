package review;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_3 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

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
            if(ch[r][c] < cur[2]) continue;
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(board[nr][nc] == 1 && ch[nr][nc] > cur[2] + 1) {
                        ch[nr][nc] = cur[2] + 1;
                        pq.add(new int[]{nr, nc, cur[2] + 1});
                    } else if(board[nr][nc] == 0 && ch[nr][nc] > cur[2]){
                        ch[nr][nc] = cur[2];
                        pq.add(new int[]{nr, nc, cur[2]});
                    }
                }
            }
        }

        return ch[n - 1][m - 1];
    }

    public static void main(String[] args){
        Q8_3 T = new Q8_3();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
