package dy.baekjoon;

import java.util.Scanner;

public class Q15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n + 2][2];
        int[] dp = new int[n + 2];
        for(int i = 1; i < n + 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a; // 기간
            arr[i][1] = b; // 금액
        }

        int max = -1;
        for(int i = 1; i < n + 2; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }

            int next = i + arr[i][0];
            if(next < n + 2) {
                dp[next] = Math.max(dp[next], max + arr[i][1]);
            }
        }

        System.out.println(dp[n + 1]);
    }
}


