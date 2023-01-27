package dfs.inflearn;

import java.util.Scanner;

// 조합 경우의 수
public class Ch8_7 {

    static int n, m;
    static int[][] mem = new int[34][34];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        System.out.println(DFS(n, m));
    }

    public static int DFS(int n, int r) {
        if(mem[n][r] != 0) return mem[n][r];
        if(n == r || r == 0) return 1;
        else {
            return mem[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }
}
