package review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // r, c, v
        ch[0][0] = 0;
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int r = tmp[0];
            int c = tmp[1];
            int v = tmp[2];
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    // 같은 방향
                    if(board[r][c] == i + 1 && ch[nr][nc] > v) {
                        ch[nr][nc] = v;
                        queue.add(new int[]{nr, nc, v});
                    }

                    if(board[r][c] != i + 1 && ch[nr][nc] > v + 1) {
                        ch[nr][nc] = v + 1;
                        queue.add(new int[]{nr, nc, v + 1});
                    }
                }
            }
        }

        return ch[n-1][m-1];
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
