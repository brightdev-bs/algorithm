package dy.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2294 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 1000001);
        dp[0] = 0;
        for (int coin : coins) {
            for(int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if(dp[k] == 1000001) System.out.println(-1);
        else System.out.println(dp[k]);

    }
}
