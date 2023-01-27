package dfs.inflearn;

import java.util.Scanner;

public class Ch8_4 {

    static int n, m;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[m];
        DFS(0);
    }

    public static void DFS(int L) {
        if(L == m) {
            for (int i : ch) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                ch[L] = i;
                DFS(L + 1);
            }
        }
    }
}
