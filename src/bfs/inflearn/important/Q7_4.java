package bfs.inflearn.important;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_4 {

    int[][] ch;
    int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] board){
        ch = new int[7][7];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        ch[0][0] = 1;
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {

                Point poll = queue.poll();
                if(poll.r == 6 && poll.c == 6) return L;
                for(int j = 0; j < 4; j++) {
                    int nr = poll.r + dr[j];
                    int nc = poll.c + dc[j];

                    if(0 <= nr && nr < 7 && 0 <= nc && nc < 7 && board[nr][nc] == 0 && ch[nr][nc] == 0) {
                        ch[nr][nc] = 1;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Q7_4 T = new Q7_4();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));

        int[][] arr2=        {{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0,
                0, 0}, {1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0,
                0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr2));
    }
}
