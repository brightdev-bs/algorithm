package review;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_5 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    final int BUILDING = 1;

    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;

        int[][] dist = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int emptyLand = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == BUILDING) {
                    answer = Integer.MAX_VALUE;
                    queue.add(new int[]{i, j});
                    int L = 0;
                    while(!queue.isEmpty()) {
                        L++;
                        int len = queue.size();
                        for(int k = 0; k < len; k++) {
                           int[] poll = queue.poll();
                           for(int l = 0; l < 4; l++) {
                               int nr = poll[0] + dr[l];
                               int nc = poll[1] + dc[l];
                               if(nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == emptyLand) {
                                   board[nr][nc]--;
                                   dist[nr][nc] += L;
                                   queue.add(new int[]{nr, nc});
                                   answer = Math.min(answer, dist[nr][nc]);
                               }
                           }
                        }
                    }
                    emptyLand--;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, dist[i][j]);
            }
        }


        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        Q7_5 T = new Q7_5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
