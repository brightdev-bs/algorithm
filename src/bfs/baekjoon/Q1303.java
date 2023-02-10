package bfs.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1303 {

    static int n, m, wSum = 0, bSum = 0;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static char[][] arr;

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
        arr = new char[m][n];
        for(int i = 0; i < m; i++) {
            String s = sc.next();
            for(int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] != 'C') {
                    char tmp = arr[i][j];
                    queue.add(new Point(i, j));
                    arr[i][j] = 'C';
                    int count = 0;
                    while(!queue.isEmpty()) {
                        Point poll = queue.poll();
                        count++;

                        for(int l = 0; l < 4; l++) {
                            int nx = poll.x + dx[l];
                            int ny = poll.y + dy[l];
                            if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == tmp) {
                                arr[nx][ny] = 'C';
                                queue.add(new Point(nx, ny));
                            }
                        }
                    }

                    if(tmp == 'W') wSum += count * count;
                    else bSum += count * count;
                }
            }
        }

        System.out.println(wSum);
        System.out.println(bSum);
    }


}
