package review;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_6 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;

        int n = board.length;
        int m = board[0].length;

        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2 || board[i][j] == 3) {
                    int[][] ch = new int[n][m];
                    int L = 0;
                    queue.add(new int[]{i, j});
                    ch[i][j] = 1;
                    while(!queue.isEmpty()) {
                        L++;
                        int len = queue.size();
                        for(int k = 0; k < len; k++) {
                            int[] cur = queue.poll();
                            for(int l = 0; l < 4; l++) {
                                int nr = cur[0] + dr[l];
                                int nc = cur[1] + dc[l];
                                if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] != 1) {
                                    if(ch[nr][nc] == 0) {
                                        ch[nr][nc] = 1;
                                        dist[nr][nc] += L;
                                        queue.add(new int[]{nr, nc});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 4 && dist[i][j] > 0) answer = Math.min(answer, dist[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q7_6 T = new Q7_6();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
