package dy.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2281 {

    static int n, m;
    static int[] arr;
    static int[][] dp = new int[21][22];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        System.out.println(solution(0, 0));
    }

    static int solution(int idx, int len) {
        if(idx >= n) return 0;

        // 이미 구한 값이면
        if(dp[idx][len] != Integer.MIN_VALUE) {
            return dp[idx][len];
        }

        // 다음 줄에 쓰는 경우
        int left = m - len + 1;
        dp[idx][len] = left * left + solution(idx + 1, arr[idx] + 1);

        // 같은 줄에 쓰는 경우
        if(len + arr[idx] <= m) {
            dp[idx][len] = Math.min(solution(idx + 1, len + arr[idx] + 1), dp[idx][len]);
        }

        return dp[idx][len];

    }
}
