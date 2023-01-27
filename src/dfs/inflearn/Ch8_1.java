package dfs.inflearn;

import java.util.Scanner;

public class Ch8_1 {

    static int n, total = 0;
    static int[] arr;
    static boolean flag = false;

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(0, 0);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void DFS(int L, int sum) {
        if(flag) return;
        if(L == n) {
            if(total - sum == sum) flag = true;
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
