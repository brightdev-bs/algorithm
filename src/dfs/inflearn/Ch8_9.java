package dfs.inflearn;

import java.util.Scanner;

// 조합 수 구하기
public class Ch8_9 {

    static int n, m;
    static int[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        out = new int[m];

        DFS(0, 1);
    }

    public static void DFS(int L, int s) {
        if(L == m) {
            for (int i : out) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                out[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}