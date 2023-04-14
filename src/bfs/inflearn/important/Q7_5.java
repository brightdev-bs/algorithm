package bfs.inflearn.important;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_5 {

    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;

        int n = board.length;
        int[][] dist = new int[n][n];

        int emptyLand = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    boolean flag = false;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    int L = 0;
                    while(!queue.isEmpty()) {
                        int len = queue.size();
                        L++;
                        for(int k = 0; k < len; k++) {
                            Point p = queue.poll();
                            for(int l = 0; l < 4; l++) {
                                int nr = p.r + dr[l];
                                int nc = p.c + dc[l];
                                if(0 <= nr && nr < n && 0 <= nc && nc < n && board[nr][nc] == emptyLand) {
                                    flag = true;
                                    queue.add(new Point(nr, nc));
                                    dist[nr][nc] += L;
                                    board[nr][nc]--;
                                }
                            }
                        }
                    }
                    if(!flag) return -1;
                    emptyLand--;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dist[i][j] != 0) answer = Math.min(answer, dist[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q7_5 T = new Q7_5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
