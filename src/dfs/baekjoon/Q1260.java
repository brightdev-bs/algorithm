package dfs.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1260 {

    static int n,m,v;
    static int[][] arr;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        arr = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        ch = new int[n + 1];
        DFS(v);
        System.out.println();
        BFS(v);
    }

    public static void DFS(int v) {
        ch[v] = 1;
        System.out.print(v + " ");
        for(int i = 1; i <= n; i++) {
            if(arr[v][i] == 1 && ch[i] == 0) {
                DFS(i);
            }
        }
    }

    public static void BFS(int v) {
        int[] ch = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        ch[v] = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Integer cur = queue.poll();
                System.out.print(cur + " ");
                for(int j = 1; j <= n; j++) {
                    if(arr[cur][j] == 1 && ch[j] == 0) {
                        ch[j] = 1;
                        queue.add(j);
                    }
                }
            }
        }
    }

}
