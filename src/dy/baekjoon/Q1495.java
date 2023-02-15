package dy.baekjoon;

import java.util.Scanner;

public class Q1495 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();


        int[] volumes = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            volumes[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][s] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(dp[i - 1][j]) {
                    if(j - volumes[i] >= 0) dp[i][j - volumes[i]] = true;
                    if(j + volumes[i] <= m) dp[i][j + volumes[i]] = true;
                }
            }
        }

        int answer = -1;
        for(int i = 0; i <= m; i++ ) {
            if(dp[n][i]) answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}



