package dy.baekjoon;

import java.util.Scanner;

public class Q1890 {

    static int n;
    static int[][] graph;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        graph = new int[n][n];
        dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }


        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int next = graph[i][j];
                if(next == 0) break;
                if(j + next < n) dp[i][j + next] += dp[i][j];
                if(i + next < n) dp[i + next][j] += dp[i][j];
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

}
