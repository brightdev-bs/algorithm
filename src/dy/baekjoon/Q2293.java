package dy.baekjoon;

import java.util.Scanner;

public class Q2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dy = new int[k + 1];
        dy[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dy[i] = dy[i] + dy[i - coin];
            }
        }

        System.out.println(dy[k]);

    }
}