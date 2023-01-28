package bfs.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch8_12 {

    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int[][] box, dis;
    static boolean flag = true;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        box = new int[m][n];
        dis = new int[m][n];

        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int input = sc.nextInt();
                box[i][j] = input;
                if(input == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Point tmp = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(box[i][j] == 0) flag = false;
            }
        }

        if(flag) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }

        if(flag) System.out.println(answer);
        else System.out.println(-1);

    }
}
