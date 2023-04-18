package graph.inflearn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_3 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, 1, 1, 0};

    public int solution(int[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] ch = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(ch[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});
        ch[0][0] = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                int v = poll[2];

                if(ch[r][c] < v) continue;
                for(int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if(0 <= nr && nr < n && 0 <= nc && nc < m && ch[nr][nc] == Integer.MAX_VALUE) {

                        if(board[nr][nc] == 0) {
                            queue.add(new int[]{nr, nc, v});
                            ch[nr][nc] = Math.min(ch[nr][nc], ch[r][c]);
                        } else {
                            queue.add(new int[]{nr, nc, v + 1});
                            ch[nr][nc] = Math.min(ch[nr][nc], ch[r][c] + 1);
                        }

                    }
                }
            }
        }

        return ch[n-1][m-1];
    }

    public static void main(String[] args) {
        Q8_3 T = new Q8_3();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
