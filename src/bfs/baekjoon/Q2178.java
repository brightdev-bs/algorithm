package bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {

    static int n, m;

    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int[][] graph;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] dis = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        dis[0][0] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for(int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && dis[nx][ny] == 0) {
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        System.out.println(dis[n - 1][m - 1]);
    }
}
