package dy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2616 {
    static final int NUMBER_OF_TRAINS = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] trains = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[4][n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            trains[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + trains[i];
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 1; i <= NUMBER_OF_TRAINS; i++) {
            for(int j = i * m; j <= n; j++) {
                dp[i][j] = Math.max(
                        dp[i][j - 1],
                        dp[i - 1][j - m] + sum[j] - sum[j - m]
                );
            }
        }

        System.out.println(dp[3][n]);

    }
}
