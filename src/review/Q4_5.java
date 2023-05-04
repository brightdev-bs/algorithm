package review;

import java.util.LinkedList;
import java.util.Queue;

public class Q4_5 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    public int solution(int[][] board){

        int n = board.length;
        int[][] answer = new int[n][n];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    int[][] ch = new int[n][n];
                    ch[i][j] = 1;
                    int L = 0;
                    while(!queue.isEmpty()) {
                        L++;
                        int len = queue.size();
                        for(int k = 0; k < len; k++) {
                            int[] cur = queue.poll();
                            for(int l = 0; l < 4; l++) {
                                int nr = cur[0] + dr[l];
                                int nc = cur[1] + dc[l];
                                if(nr >= 0 && nr < n && nc >= 0 && nc < n && (board[nr][nc] == 0 || board[nr][nc] == 1) && ch[nr][nc] == 0) {
                                    answer[nr][nc] += L;
                                    ch[nr][nc] = 1;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(answer[i][j] != 0)
                    res = Math.min(res, answer[i][j]);
            }
        }

        return res;
    }

    public static void main(String[] args){
        Q4_5 T = new Q4_5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
