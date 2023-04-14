package bfs.inflearn.important;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_6 {

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
        int n2 = board[0].length;
        int emptyLand = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n2; j++) {
                if(board[i][j] == 4) {
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                    int L = 0;
                    while(!queue.isEmpty()) {
                        L++;
                        int len = queue.size();
                        for(int k = 0; k < len; k++) {
                            Point p = queue.poll();
                            for(int l = 0; l < 4; l++) {
                                int nr = p.r + dr[l];
                                int nc = p.c + dc[l];
                                if(0 <= nr && nr < n && 0 <= nc && nc < n2) {
                                    if(board[nr][nc] == emptyLand) {
                                        queue.add(new Point(nr, nc));
                                        board[nr][nc]--;
                                    }
                                    if(board[nr][nc] == 2 && a == Integer.MAX_VALUE) {
                                        queue.add(new Point(nr, nc));
                                        a = L;
                                    }
                                    if(board[nr][nc] == 3 && b == Integer.MAX_VALUE) {
                                        queue.add(new Point(nr, nc));
                                        b = L;
                                    }
                                }
                            }
                        }
                    }
                    emptyLand--;
                    if(a != Integer.MAX_VALUE && b != Integer.MAX_VALUE)
                        answer = Math.min(answer, a + b);
                }
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
