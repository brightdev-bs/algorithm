package dfs.inflearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ch8_5 {

    static int n, m, answer = Integer.MAX_VALUE;
    static Integer[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 동전의 개수
        coins = new Integer[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());

        m = sc.nextInt();

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int cnt, int sum) {
        if(cnt >= answer) return;
        if(sum > m) return;
        if(sum == m) answer = Math.min(answer, cnt);
        else {
            for(int i = 0; i < n; i++) {
                DFS(cnt + 1, sum + coins[i]);
            }
        }
    }
}
