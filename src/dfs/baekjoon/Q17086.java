package dfs.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q17086 {

    static int n, m;

    static int[] dr = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }, dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int[][] arr, ch;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        ch = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ch[i][j] = Integer.MAX_VALUE;
            }
        }

        List<Point> sharks = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    sharks.add(new Point(i, j));
                    ch[i][j] = 1;
                }
            }
        }

        for (Point shark : sharks) {
            dfs(shark.r, shark.c);
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer = Math.max(ch[i][j], answer);
            }
        }

        System.out.println(answer - 1);
    }

    public static void dfs(int r, int c) {
        for(int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && ch[nr][nc] > ch[r][c] + 1) {
                ch[nr][nc] = ch[r][c] + 1;
                dfs(nr, nc);
            }
        }
    }
}
