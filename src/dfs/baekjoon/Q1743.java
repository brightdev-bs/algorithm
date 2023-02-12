package dfs.baekjoon;

import java.util.Scanner;

public class Q1743 {

    static int n,m,k;
    static int sum;

    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    static boolean[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        graph = new boolean[n][m];
        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            graph[r-1][c-1] = true;
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum = 0;
                if(graph[i][j]) {
                    DFS(i, j);
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int r, int c) {
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && graph[nr][nc]) {
                graph[nr][nc] = false;
                sum++;
                DFS(nr, nc);
            }
        }
    }
}
