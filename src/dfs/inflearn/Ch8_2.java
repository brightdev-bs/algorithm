package dfs.inflearn;

import java.util.Scanner;

public class Ch8_2 {

    public static int c, n, answer = Integer.MIN_VALUE;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum) {
        if(L == n) {
            if(sum <= c) answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
