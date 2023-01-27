package dfs.inflearn;

import java.util.Scanner;

public class Ch8_6 {

    static int n, m;
    static int[] arr, ch, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 자연수 개수
        m = sc.nextInt(); // 뽑는 횟수

        arr = new int[n];
        ch = new int[n];
        answer = new int[m];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);
    }

    public static void DFS(int L) {
        if(L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    answer[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
