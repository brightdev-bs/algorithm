package dy.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2281 {

    static int n, m;
    static int[] arr;
    static int[][] dp = new int[1001][1002];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solution(0, 0));
    }

    static int solution(int name, int len) {
        if(name >= n) return 0;

        // 이미 구한 값이면
        if(dp[name][len] != -1) {
            return dp[name][len];
        }

        // 다음 줄에 쓰는 경우
        int left = m - len + 1;
        dp[name][len] = left * left + solution(name + 1, arr[name] + 1);

        // 같은 줄에 쓰는 경우
        if(len + arr[name] <= m) {
            dp[name][len] = Math.min(solution(name + 1, len + arr[name] + 1), dp[name][len]);
        }

        return dp[name][len];

    }
}
